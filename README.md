productStorage
For this project i use postgresql use this script to create database:

CREATE SEQUENCE product_id_seq;
CREATE TABLE products(
    id int NOT NULL DEFAULT nextval('product_id_seq'),
    name varchar(30),
    description varchar(200)
);
ALTER SEQUENCE product_id_seq OWNED BY products.id;


INSERT INTO products(name, description) VALUES ('ball', 'Ball for learning to play football and outdoor activities. Thanks to the eco-friendly material and low weight, the model is suitable for children.');

INSERT INTO products(name, description) VALUES ('mug', 'The mug is made of heat-resistant borosilicate glass.');
INSERT INTO products(name, description) VALUES ('forks', 'The set consists of three table forks. Made of high quality stainless steel, the item thickness is 4 mm.');
INSERT INTO products(name, description) VALUES ('jewelry_box', 'Made of high-quality artificial leather and soft velvet');
