-- Verify 10 users were added
SELECT COUNT(*) FROM profile.user;
-- expect: 10

-- Verify links were added for all users
SELECT COUNT(*) FROM profile.user_links;
-- expect: 10

-- Verify that UUID columns are populated
SELECT COUNT(*) FROM profile.user WHERE id_uuid IS NULL;
-- expect: 0

SELECT COUNT(*) FROM profile.user_links WHERE id_uuid IS NULL;
-- expect: 0

-- Verify the links were properly created
SELECT COUNT(DISTINCT u.id)
FROM profile.user u
JOIN profile.user_links x ON u.id = x.user_id AND x.x_link IS NOT NULL
JOIN profile.user_links fb ON u.id = fb.user_id AND fb.facebook_link IS NOT NULL
JOIN profile.user_links yt ON u.id = yt.user_id AND yt.youtube_link IS NOT NULL
JOIN profile.user_links md ON u.id = md.user_id AND md.medium_link IS NOT NULL;
-- expect: 10