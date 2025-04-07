-- liquibase formatted sql

-- changeset author:diegopacheco:1
CREATE SCHEMA IF NOT EXISTS profile;

-- changeset author:diegopacheco:2
CREATE TABLE IF NOT EXISTS profile.user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(512)
);

-- changeset author:diegopacheco:3
CREATE TABLE IF NOT EXISTS profile.user_links (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    x_link VARCHAR(255),
    facebook_link VARCHAR(255),
    youtube_link VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES profile.user(id) ON DELETE CASCADE
);