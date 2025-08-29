USE partitiondb;

-- Create partitioned users table based on first letter of name
-- Add a computed column for partitioning
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    activated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    name_first_char VARCHAR(1) GENERATED ALWAYS AS (LEFT(UPPER(name), 1)) STORED,
    PRIMARY KEY (id, name_first_char),
    UNIQUE KEY unique_email (email, name_first_char),
    KEY idx_name (name)
) ENGINE=InnoDB
PARTITION BY LIST COLUMNS(name_first_char) (
    PARTITION p_a_c VALUES IN ('A','B','C'),
    PARTITION p_d_f VALUES IN ('D','E','F'),
    PARTITION p_g_i VALUES IN ('G','H','I'),
    PARTITION p_j_l VALUES IN ('J','K','L'),
    PARTITION p_m_o VALUES IN ('M','N','O'),
    PARTITION p_p_r VALUES IN ('P','Q','R'),
    PARTITION p_s_u VALUES IN ('S','T','U'),
    PARTITION p_v_z VALUES IN ('V','W','X','Y','Z'),
    PARTITION p_other VALUES IN ('0','1','2','3','4','5','6','7','8','9')
);

-- Insert some test data to demonstrate partitioning
INSERT INTO users (name, last_name, email) VALUES 
('Alice', 'Johnson', 'alice.johnson@example.com'),
('Bob', 'Smith', 'bob.smith@example.com'),
('Charlie', 'Brown', 'charlie.brown@example.com'),
('David', 'Wilson', 'david.wilson@example.com'),
('Emma', 'Davis', 'emma.davis@example.com'),
('Frank', 'Miller', 'frank.miller@example.com'),
('Grace', 'Garcia', 'grace.garcia@example.com'),
('Henry', 'Martinez', 'henry.martinez@example.com'),
('Ivy', 'Anderson', 'ivy.anderson@example.com'),
('Jack', 'Taylor', 'jack.taylor@example.com'),
('Kate', 'Thomas', 'kate.thomas@example.com'),
('Leo', 'Jackson', 'leo.jackson@example.com'),
('Maria', 'White', 'maria.white@example.com'),
('Nick', 'Harris', 'nick.harris@example.com'),
('Olivia', 'Martin', 'olivia.martin@example.com'),
('Peter', 'Thompson', 'peter.thompson@example.com'),
('Quinn', 'Garcia', 'quinn.garcia@example.com'),
('Rachel', 'Martinez', 'rachel.martinez@example.com'),
('Sam', 'Robinson', 'sam.robinson@example.com'),
('Tom', 'Clark', 'tom.clark@example.com'),
('Uma', 'Rodriguez', 'uma.rodriguez@example.com'),
('Victor', 'Lewis', 'victor.lewis@example.com'),
('Wendy', 'Lee', 'wendy.lee@example.com'),
('Xavier', 'Walker', 'xavier.walker@example.com'),
('Yara', 'Hall', 'yara.hall@example.com'),
('Zoe', 'Allen', 'zoe.allen@example.com');