CREATE DATABASE IF NOT EXISTS appdb;
USE appdb;

CREATE TABLE users (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE preferences (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    userid CHAR(36) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    sol_version VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE transactions (
    id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
    user_id CHAR(36) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    type ENUM('credit', 'debit') NOT NULL,
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_preferences_userid ON preferences(userid);
CREATE INDEX idx_transactions_userid ON transactions(user_id);
CREATE INDEX idx_transactions_type ON transactions(type);

INSERT INTO users (id, name, email, address) VALUES
('u001', 'John Doe', 'john.doe@example.com', '123 Main St, Anytown, NY 12345'),
('u002', 'Jane Smith', 'jane.smith@example.com', '456 Oak Ave, Springfield, CA 90210'),
('u003', 'Bob Johnson', 'bob.johnson@example.com', '789 Pine Rd, Riverside, TX 75001'),
('u004', 'Alice Brown', 'alice.brown@example.com', '321 Elm St, Madison, WI 53703'),
('u005', 'Charlie Wilson', 'charlie.wilson@example.com', '654 Maple Dr, Portland, OR 97205'),
('u006', 'Diana Davis', 'diana.davis@example.com', '987 Cedar Ln, Denver, CO 80202'),
('u007', 'Eve Miller', 'eve.miller@example.com', '147 Birch Ct, Seattle, WA 98101'),
('u008', 'Frank Garcia', 'frank.garcia@example.com', '258 Willow Way, Miami, FL 33101'),
('u009', 'Grace Lee', 'grace.lee@example.com', '369 Spruce St, Boston, MA 02101'),
('u010', 'Henry Taylor', 'henry.taylor@example.com', '741 Poplar Ave, Chicago, IL 60601');

INSERT INTO preferences (id, userid, is_active, sol_version) VALUES
('p001', 'u001', TRUE, '1.0.0'),
('p002', 'u002', TRUE, '1.1.0'),
('p003', 'u003', FALSE, '0.9.0'),
('p004', 'u004', TRUE, '1.2.0'),
('p005', 'u005', TRUE, '1.0.5'),
('p006', 'u006', FALSE, '0.8.0'),
('p007', 'u007', TRUE, '1.3.0'),
('p008', 'u008', TRUE, '1.1.5'),
('p009', 'u009', FALSE, '0.9.5'),
('p010', 'u010', TRUE, '1.4.0');

INSERT INTO transactions (id, user_id, amount, type, notes) VALUES
('t001', 'u001', 500.00, 'credit', 'Initial deposit'),
('t002', 'u001', 50.00, 'debit', 'Coffee shop purchase'),
('t003', 'u002', 1000.00, 'credit', 'Salary deposit'),
('t004', 'u002', 150.00, 'debit', 'Grocery shopping'),
('t005', 'u003', 250.00, 'credit', 'Freelance payment'),
('t006', 'u004', 75.00, 'debit', 'Gas station'),
('t007', 'u005', 2000.00, 'credit', 'Bonus payment'),
('t008', 'u005', 300.00, 'debit', 'Online shopping'),
('t009', 'u007', 750.00, 'credit', 'Investment return'),
('t010', 'u008', 120.00, 'debit', 'Restaurant bill');