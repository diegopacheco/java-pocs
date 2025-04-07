-- Verify id_uuid column exists in user table
SELECT COUNT(*) FROM information_schema.columns
WHERE table_schema = 'profile' AND table_name = 'user'
AND column_name = 'id_uuid';
-- expect: 1

-- Verify id_uuid column exists in user_links table
SELECT COUNT(*) FROM information_schema.columns
WHERE table_schema = 'profile' AND table_name = 'user_links'
AND column_name = 'id_uuid';
-- expect: 1

-- Verify that id_uuid columns are populated (no NULLs)
SELECT COUNT(*) FROM profile.user WHERE id_uuid IS NULL;
-- expect: 0

SELECT COUNT(*) FROM profile.user_links WHERE id_uuid IS NULL;
-- expect: 0