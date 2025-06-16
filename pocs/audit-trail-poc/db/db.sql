-- Create the audit database if it doesn't exist
CREATE DATABASE IF NOT EXISTS audit_db;

-- Select the database to use
USE audit_db;

-- Display confirmation message
SELECT 'audit_db database created successfully' AS 'Message';