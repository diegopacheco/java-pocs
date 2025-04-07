-- Drop the id_uuid column from user_links
ALTER TABLE profile.user_links DROP COLUMN id_uuid;

-- Drop the id_uuid column from user
ALTER TABLE profile.user DROP COLUMN id_uuid;