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
                                `condition` VARCHAR(255),          -- 已存在的 condition 字段
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