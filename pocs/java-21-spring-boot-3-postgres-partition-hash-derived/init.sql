CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) PARTITION BY HASH (hashtext(left(name, 1)));

CREATE TABLE IF NOT EXISTS users_p0 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 0);
CREATE TABLE IF NOT EXISTS users_p1 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 1);
CREATE TABLE IF NOT EXISTS users_p2 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 2);
CREATE TABLE IF NOT EXISTS users_p3 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 3);
CREATE TABLE IF NOT EXISTS users_p4 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 4);
CREATE TABLE IF NOT EXISTS users_p5 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 5);
CREATE TABLE IF NOT EXISTS users_p6 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 6);
CREATE TABLE IF NOT EXISTS users_p7 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 7);
CREATE TABLE IF NOT EXISTS users_p8 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 8);
CREATE TABLE IF NOT EXISTS users_p9 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 9);
CREATE TABLE IF NOT EXISTS users_p10 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 10);
CREATE TABLE IF NOT EXISTS users_p11 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 11);
CREATE TABLE IF NOT EXISTS users_p12 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 12);
CREATE TABLE IF NOT EXISTS users_p13 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 13);
CREATE TABLE IF NOT EXISTS users_p14 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 14);
CREATE TABLE IF NOT EXISTS users_p15 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 15);
CREATE TABLE IF NOT EXISTS users_p16 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 16);
CREATE TABLE IF NOT EXISTS users_p17 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 17);
CREATE TABLE IF NOT EXISTS users_p18 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 18);
CREATE TABLE IF NOT EXISTS users_p19 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 19);
CREATE TABLE IF NOT EXISTS users_p20 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 20);
CREATE TABLE IF NOT EXISTS users_p21 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 21);
CREATE TABLE IF NOT EXISTS users_p22 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 22);
CREATE TABLE IF NOT EXISTS users_p23 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 23);
CREATE TABLE IF NOT EXISTS users_p24 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 24);
CREATE TABLE IF NOT EXISTS users_p25 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 25);
CREATE TABLE IF NOT EXISTS users_p26 PARTITION OF users FOR VALUES WITH (MODULUS 27, REMAINDER 26);

CREATE INDEX IF NOT EXISTS idx_users_p0_email ON users_p0 (email);
CREATE INDEX IF NOT EXISTS idx_users_p1_email ON users_p1 (email);
CREATE INDEX IF NOT EXISTS idx_users_p2_email ON users_p2 (email);
CREATE INDEX IF NOT EXISTS idx_users_p3_email ON users_p3 (email);
CREATE INDEX IF NOT EXISTS idx_users_p4_email ON users_p4 (email);
CREATE INDEX IF NOT EXISTS idx_users_p5_email ON users_p5 (email);
CREATE INDEX IF NOT EXISTS idx_users_p6_email ON users_p6 (email);
CREATE INDEX IF NOT EXISTS idx_users_p7_email ON users_p7 (email);
CREATE INDEX IF NOT EXISTS idx_users_p8_email ON users_p8 (email);
CREATE INDEX IF NOT EXISTS idx_users_p9_email ON users_p9 (email);
CREATE INDEX IF NOT EXISTS idx_users_p10_email ON users_p10 (email);
CREATE INDEX IF NOT EXISTS idx_users_p11_email ON users_p11 (email);
CREATE INDEX IF NOT EXISTS idx_users_p12_email ON users_p12 (email);
CREATE INDEX IF NOT EXISTS idx_users_p13_email ON users_p13 (email);
CREATE INDEX IF NOT EXISTS idx_users_p14_email ON users_p14 (email);
CREATE INDEX IF NOT EXISTS idx_users_p15_email ON users_p15 (email);
CREATE INDEX IF NOT EXISTS idx_users_p16_email ON users_p16 (email);
CREATE INDEX IF NOT EXISTS idx_users_p17_email ON users_p17 (email);
CREATE INDEX IF NOT EXISTS idx_users_p18_email ON users_p18 (email);
CREATE INDEX IF NOT EXISTS idx_users_p19_email ON users_p19 (email);
CREATE INDEX IF NOT EXISTS idx_users_p20_email ON users_p20 (email);
CREATE INDEX IF NOT EXISTS idx_users_p21_email ON users_p21 (email);
CREATE INDEX IF NOT EXISTS idx_users_p22_email ON users_p22 (email);
CREATE INDEX IF NOT EXISTS idx_users_p23_email ON users_p23 (email);
CREATE INDEX IF NOT EXISTS idx_users_p24_email ON users_p24 (email);
CREATE INDEX IF NOT EXISTS idx_users_p25_email ON users_p25 (email);
CREATE INDEX IF NOT EXISTS idx_users_p26_email ON users_p26 (email);

CREATE INDEX IF NOT EXISTS idx_users_p0_name ON users_p0 (name);
CREATE INDEX IF NOT EXISTS idx_users_p1_name ON users_p1 (name);
CREATE INDEX IF NOT EXISTS idx_users_p2_name ON users_p2 (name);
CREATE INDEX IF NOT EXISTS idx_users_p3_name ON users_p3 (name);
CREATE INDEX IF NOT EXISTS idx_users_p4_name ON users_p4 (name);
CREATE INDEX IF NOT EXISTS idx_users_p5_name ON users_p5 (name);
CREATE INDEX IF NOT EXISTS idx_users_p6_name ON users_p6 (name);
CREATE INDEX IF NOT EXISTS idx_users_p7_name ON users_p7 (name);
CREATE INDEX IF NOT EXISTS idx_users_p8_name ON users_p8 (name);
CREATE INDEX IF NOT EXISTS idx_users_p9_name ON users_p9 (name);
CREATE INDEX IF NOT EXISTS idx_users_p10_name ON users_p10 (name);
CREATE INDEX IF NOT EXISTS idx_users_p11_name ON users_p11 (name);
CREATE INDEX IF NOT EXISTS idx_users_p12_name ON users_p12 (name);
CREATE INDEX IF NOT EXISTS idx_users_p13_name ON users_p13 (name);
CREATE INDEX IF NOT EXISTS idx_users_p14_name ON users_p14 (name);
CREATE INDEX IF NOT EXISTS idx_users_p15_name ON users_p15 (name);
CREATE INDEX IF NOT EXISTS idx_users_p16_name ON users_p16 (name);
CREATE INDEX IF NOT EXISTS idx_users_p17_name ON users_p17 (name);
CREATE INDEX IF NOT EXISTS idx_users_p18_name ON users_p18 (name);
CREATE INDEX IF NOT EXISTS idx_users_p19_name ON users_p19 (name);
CREATE INDEX IF NOT EXISTS idx_users_p20_name ON users_p20 (name);
CREATE INDEX IF NOT EXISTS idx_users_p21_name ON users_p21 (name);
CREATE INDEX IF NOT EXISTS idx_users_p22_name ON users_p22 (name);
CREATE INDEX IF NOT EXISTS idx_users_p23_name ON users_p23 (name);
CREATE INDEX IF NOT EXISTS idx_users_p24_name ON users_p24 (name);
CREATE INDEX IF NOT EXISTS idx_users_p25_name ON users_p25 (name);
CREATE INDEX IF NOT EXISTS idx_users_p26_name ON users_p26 (name);

INSERT INTO users (name, email) VALUES
('John Doe', 'john.doe@example.com'),
('Jane Smith', 'jane.smith@example.com'),
('Alice Johnson', 'alice.johnson@example.com'),
('Bob Wilson', 'bob.wilson@example.com'),
('Charlie Brown', 'charlie.brown@example.com'),
('Diana Prince', 'diana.prince@example.com'),
('Frank Miller', 'frank.miller@example.com'),
('Grace Davis', 'grace.davis@example.com'),
('Henry Jones', 'henry.jones@example.com'),
('Ivy Chen', 'ivy.chen@example.com'),
('Jack White', 'jack.white@example.com'),
('Karen Lee', 'karen.lee@example.com'),
('Leo Garcia', 'leo.garcia@example.com'),
('Mary Johnson', 'mary.johnson@example.com'),
('Nick Taylor', 'nick.taylor@example.com'),
('Olivia Moore', 'olivia.moore@example.com'),
('Peter Parker', 'peter.parker@example.com'),
('Quinn Adams', 'quinn.adams@example.com'),
('Rachel Green', 'rachel.green@example.com'),
('Steve Rogers', 'steve.rogers@example.com'),
('Tony Stark', 'tony.stark@example.com'),
('Bruce Wayne', 'bruce.wayne@example.com'),
('Clark Kent', 'clark.kent@example.com'),
('Barry Allen', 'barry.allen@example.com'),
('Hal Jordan', 'hal.jordan@example.com'),
('Arthur Curry', 'arthur.curry@example.com'),
('Victor Stone', 'victor.stone@example.com'),
('Kara Danvers', 'kara.danvers@example.com'),
('Oliver Queen', 'oliver.queen@example.com'),
('Sara Lance', 'sara.lance@example.com')
;