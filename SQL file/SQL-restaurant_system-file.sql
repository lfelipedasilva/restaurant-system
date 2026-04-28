CREATE DATABASE restaurant_system;

USE restaurant_system;

CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT,
name_prod VARCHAR(100), 
price DECIMAL(10, 2)
);

CREATE TABLE orders (
id INT PRIMARY KEY AUTO_INCREMENT, 
date_order DATE, 
status_order VARCHAR(100)
);

CREATE TABLE orderitems (
order_id INT NOT NULL, 
product_id INT NOT NULL, 
quantity INT NOT NULL, 
purchase_price DECIMAL(10, 2),


FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (product_id) REFERENCES products(id)
);