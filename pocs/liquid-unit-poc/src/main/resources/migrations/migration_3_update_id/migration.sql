-- liquibase formatted sql

-- changeset author:diegopacheco:5
ALTER TABLE profile.user ADD COLUMN id_uuid VARCHAR(36);

-- changeset author:diegopacheco:6
UPDATE profile.user SET id_uuid = UUID();

-- changeset author:diegopacheco:7
ALTER TABLE profile.user_links ADD COLUMN id_uuid VARCHAR(36);

-- changeset author:diegopacheco:8
UPDATE profile.user_links ul
JOIN profile.user u ON ul.user_id = u.id
SET ul.id_uuid = u.id_uuid;