create database if not exists virtual_shop;
use virtual_shop;

CREATE TABLE product (
id INT PRIMARY KEY auto_increment,
product_code VARCHAR(9),
product_name VARCHAR(100),
product_description VARCHAR(255),
product_price DECIMAL(10,2),
product_quantity INT,
product_status VARCHAR(10),
product_category VARCHAR(24),
product_img VARCHAR(24),
product_rating SMALLINT
);

INSERT INTO product (product_code, product_name, product_description, product_price, product_quantity, product_status, product_category, product_img, product_rating)
VALUES 
    ('f230fh0g3', 'Bamboo Watch', 'Product Description', 28.90, 25, 'INSTOCK', 'Accessories', 'img001.jpg', 4),
    ('nvklal433', 'gold ring', 'Product Description', 45.00, 36, 'INSTOCK', 'Accessories', 'img002.jpg', 8),
    ('zz21cz3c1', 'Red Hat', 'Product Description', 13.90, 0, 'OUTOFSTOCK', 'Clothing', 'img003.jpg', 9),
    ('244wgerg2', 'Gaming Set', 'Product Description', 125.49, 7, 'LOWSTOCK', 'Electronics', 'img004.jpg', 2),
    ('av2231fwg', 'Yoga Mat', 'Product Description', 39.99, 25, 'INSTOCK', 'Fitness', 'img005.jpg', 8);