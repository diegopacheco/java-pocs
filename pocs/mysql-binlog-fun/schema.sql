CREATE DATABASE IF NOT EXISTS test;
USE test;
CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    mail VARCHAR(200));

INSERT INTO users (name,mail) VALUES ('Diego','diego.pacheco@email.com');

select * from test.users;