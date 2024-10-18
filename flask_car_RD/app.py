from flask import Flask, request, jsonify
import joblib
import pandas as pd
import numpy as np
from sklearn.metrics.pairwise import cosine_similarity
import tensorflow as tf
from keras.api.models import load_model

# 创建Flask应用
app = Flask(__name__)

# --- 加载保存的模型 ---
word2vec_model = joblib.load('word2vec_model.pkl')
scaler = joblib.load('scaler.pkl')
kmeans_model = joblib.load('kmeans_model.pkl')
# 不编译模型，避免编译时出错
matrix_factorization_model = load_model('matrix_factorization_model.h5', compile=False)

# 重新编译模型，手动指定损失函数
matrix_factorization_model.compile(optimizer='adam', loss='mse')

# 加载干净的车辆数据
df = pd.read_csv("clean_data.csv")

# 加载干净的车辆数据
df = pd.read_csv("clean_data.csv")

# 如果 'carId' 列不存在，创建该列
if 'carId' not in df.columns:
    df['carId'] = df.index

# 确保 'carId' 列已经存在
car_ids = df['carId'].unique().tolist()

# 特征列
features = ['year', 'make', 'model', 'trim', 'body', 'transmission', 'color', 'interior', 'car_age']

# 初始化编码映射
car_ids = df['carId'].unique().tolist()
car2car_encoded = {x: i for i, x in enumerate(car_ids)}
car_encoded2car = {i: x for i, x in enumerate(car_ids)}

# 数据预处理：Word2Vec嵌入和标准化
df['carId'] = df.index
car_vectors = df.apply(lambda car: np.mean([word2vec_model.wv[feature] for feature in car[features].values.astype(str) if feature in word2vec_model.wv] or [np.zeros(100)], axis=0), axis=1).tolist()
car_vectors = scaler.transform(car_vectors)

# 基于内容的推荐函数
def content_based_recommendation(user_input, top_n=10):
    try:
        user_vector = np.mean([word2vec_model.wv[feature] for feature in user_input.values() if feature in word2vec_model.wv] or [np.zeros(100)], axis=0)
        user_vector = scaler.transform([user_vector])
        similarities = cosine_similarity(user_vector, car_vectors)[0]
        similar_car_indices = np.argsort(similarities)[::-1][:top_n]
        return df.iloc[similar_car_indices]
    except Exception as e:
        print(f"Error in content_based_recommendation: {e}")
        return pd.DataFrame()

# 矩阵分解推荐函数
def matrix_factorization_recommendation(user_ratings, user_id, top_n=10):
    try:
        if user_ratings.empty:
            return pd.DataFrame()  # 如果用户评分为空，返回空结果

        # 初始化用户ID编码映射
        user_ids = user_ratings['userId'].unique().tolist()
        user2user_encoded = {x: i for i, x in enumerate(user_ids)}
        #user_encoded2user = {i: x for i, x in enumerate(user_ids)}

        cars_not_watched = df[~df["carId"].isin(user_ratings['carId'])]["carId"]
        cars_not_watched_encoded = [car2car_encoded.get(x) for x in cars_not_watched if x in car2car_encoded]
        
        user_encoded = user2user_encoded.get(user_id)
        if user_encoded is None:
            return pd.DataFrame()  # 如果用户ID未找到，返回空结果

        user_car_array = np.hstack(([[user_encoded]] * len(cars_not_watched_encoded), np.array(cars_not_watched_encoded).reshape(-1, 1)))

        predictions = matrix_factorization_model.predict([user_car_array[:, 0], user_car_array[:, 1]]).flatten()
        top_rated_indices = predictions.argsort()[-top_n:][::-1]

        recommended_car_ids = [car_encoded2car.get(cars_not_watched_encoded[x]) for x in top_rated_indices]
        recommended_cars = df[df["carId"].isin(recommended_car_ids)]
        return recommended_cars
    except Exception as e:
        print(f"Error in matrix_factorization_recommendation: {e}")
        return pd.DataFrame()

# Flask路由用于处理推荐请求
@app.route('/recommend', methods=['POST'])
def recommend():
    try:
        # 获取用户输入数据
        search_data = request.get_json()
        print("Received search data: ", search_data)

        # 构建用户输入字典
        user_input = {
            'year': search_data.get('year', 'Unknown'),
            'make': search_data.get('make', 'Unknown'),
            'model': search_data.get('model', 'Unknown'),
            'trim': search_data.get('trim', 'Unknown'),
            'body': search_data.get('body', 'Unknown'),
            'transmission': search_data.get('transmission', 'Unknown'),
            'color': search_data.get('color', 'Unknown'),
            'interior': search_data.get('interior', 'Unknown'),
            'car_age': search_data.get('car_age', 1)
        }

        # 首先使用基于内容的推荐
        recommendations = content_based_recommendation(user_input)

        # 检查是否提供了用户评分数据，如果有则使用矩阵分解推荐
        if 'user_ratings' in search_data:
            user_ratings = pd.DataFrame(search_data['user_ratings'])  # 假设评分数据结构为 [{'carId': X, 'rating': Y}]
            user_id = search_data.get('user_id', 0)  # 如果没有提供用户ID，假设为0
            recommendations = matrix_factorization_recommendation(user_ratings, user_id)

        # 返回推荐结果
        if recommendations.empty:
            return jsonify([]), 200
        return jsonify(recommendations.to_dict(orient="records")), 200
    
    except Exception as e:
        print(f"Error in /recommend route: {e}")
        return jsonify({"error": str(e)}), 500

# 启动Flask服务
if __name__ == "__main__":
    app.run(port=5000, debug=True)
