-- Verify medium_link column exists
SELECT COUNT(*) FROM information_schema.columns
WHERE table_schema = 'profile' AND table_name = 'user_links'
AND column_name = 'medium_link';
-- expect: 1

-- Check for non-null values in the links table
SELECT COUNT(*) FROM profile.user_links WHERE medium_link IS NULL;
-- expect: 0