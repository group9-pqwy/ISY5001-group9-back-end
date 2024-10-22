CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE search_history (
    search_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    make VARCHAR(255),
    model VARCHAR(255),
    color VARCHAR(255),
    trim VARCHAR(255),
    body VARCHAR(255),
    transmission VARCHAR(255),
    vin VARCHAR(255),               -- 添加 vin 字段
    state VARCHAR(255),              -- 添加 state 字段
    'condition' VARCHAR(255),          -- 已存在的 condition 字段
    min_odometer INT,                -- 添加 minOdometer 字段
    max_odometer INT,                -- 添加 maxOdometer 字段
    interior VARCHAR(255),
    seller VARCHAR(255),
    mmr DECIMAL(10, 2),              -- 添加 mmr 字段
    min_price DECIMAL(10, 2),        -- 添加 minPrice 字段
    max_price DECIMAL(10, 2),        -- 添加 maxPrice 字段
    search_time TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
-- 插入用户数据
INSERT INTO users (user_id, username, password) VALUES (1, 'user1', 'password1');

-- 插入搜索记录数据
INSERT INTO search_history (user_id, make, model, color, trim, body, transmission, vin, state, `condition`, min_odometer, max_odometer, interior, seller, mmr, min_price, max_price, search_time)
VALUES 
(1, 'Toyota', 'Camry', 'Black', 'LE', 'Sedan', 'Automatic', '1HGBH41JXMN109186', 'CA', 'Used', 5000, 15000, 'Black', 'CarDealerX', 20000, 15000, 25000, NOW());


SELECT
    make,
    model,
    COUNT(*) AS frequency
FROM
    search_history
WHERE
    user_id = 1  -- 替换成实际的用户 ID
GROUP BY
    make, model
ORDER BY
    frequency DESC
    LIMIT
    5;         -- 限制返回结果的数量，可以根据实际情况调整
-- 统计用户搜索关键词频次
SELECT make, model, COUNT(*) AS frequency
FROM search_history
WHERE user_id = 1
GROUP BY make, model
ORDER BY frequency DESC;