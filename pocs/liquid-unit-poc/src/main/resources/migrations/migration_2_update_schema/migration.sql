-- liquibase formatted sql

-- changeset author:diegopacheco:4
ALTER TABLE profile.user_links ADD COLUMN medium_link VARCHAR(255);