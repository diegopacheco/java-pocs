-- liquibase formatted sql

-- changeset author:diegopacheco:9
INSERT INTO profile.user (name, email, id_uuid) VALUES
('John Doe', 'john.doe@example.com', UUID()),
('Jane Smith', 'jane.smith@example.com', UUID()),
('David Johnson', 'david.johnson@example.com', UUID()),
('Emma Williams', 'emma.williams@example.com', UUID()),
('Michael Brown', 'michael.brown@example.com', UUID()),
('Olivia Jones', 'olivia.jones@example.com', UUID()),
('William Davis', 'william.davis@example.com', UUID()),
('Sophia Miller', 'sophia.miller@example.com', UUID()),
('James Wilson', 'james.wilson@example.com', UUID()),
('Emily Taylor', 'emily.taylor@example.com', UUID());

-- changeset author:diegopacheco:10
-- Add all links for users in a single insert
INSERT INTO profile.user_links
(user_id, x_link, facebook_link, youtube_link, medium_link, id_uuid)
SELECT
  id,
  CONCAT('https://twitter.com/user', id),
  CONCAT('https://facebook.com/user', id),
  CONCAT('https://youtube.com/user', id),
  CONCAT('https://medium.com/@user', id),
  id_uuid
FROM profile.user;