-- test.sql

-- Verify the profile schema
SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name = 'profile';
-- expect: 1

-- Verify the profile schema
SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'profile' AND table_name = 'user';
-- expect: 1

-- Verify the user table
SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'profile' AND table_name = 'user_links';
-- expect: 1

-- Verify columns in user table
SELECT COUNT(*) FROM information_schema.columns
WHERE table_schema = 'profile' AND table_name = 'user' AND column_name IN ('id', 'name', 'email', 'address');
-- expect: 4

-- Verify columns in user_links table
SELECT COUNT(*) FROM information_schema.columns
WHERE table_schema = 'profile' AND table_name = 'user_links'
AND column_name IN ('id', 'user_id', 'x_link', 'facebook_link', 'youtube_link');
-- expect: 5

-- Verify foreign key constraint
SELECT COUNT(*) FROM information_schema.key_column_usage
WHERE table_schema = 'profile' AND table_name = 'user_links'
AND column_name = 'user_id' AND referenced_table_name = 'user';
-- expect: 1