-- src/main/resources/schema.sql
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NULL
);

-- Add some test data (optional - for runtime only)
INSERT INTO users (name, email) VALUES ('User 1', 'user1@example.com');
INSERT INTO users (name, email) VALUES ('User 2', 'user2@example.com');