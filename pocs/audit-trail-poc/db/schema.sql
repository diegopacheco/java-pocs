USE audit_db;
CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    CONSTRAINT uk_user_email UNIQUE (email),
    CONSTRAINT uk_user_phone UNIQUE (phone)
);

CREATE TABLE IF NOT EXISTS audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    event VARCHAR(500) NOT NULL,
    user_id VARCHAR(36)
);

CREATE INDEX idx_audit_user_id ON audit(user_id);
CREATE INDEX idx_user_email ON users(email);

SELECT 'Schema created successfully' AS 'Message';