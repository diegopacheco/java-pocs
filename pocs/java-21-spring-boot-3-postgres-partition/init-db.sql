CREATE TABLE users (
    id BIGSERIAL,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    username_first_char CHAR(1) NOT NULL,
    PRIMARY KEY (id, username_first_char)
) PARTITION BY RANGE (username_first_char);

CREATE UNIQUE INDEX users_username_unique ON users (username, username_first_char);

CREATE TABLE users_others PARTITION OF users FOR VALUES FROM (MINVALUE) TO ('a');
CREATE TABLE users_a PARTITION OF users FOR VALUES FROM ('a') TO ('b');
CREATE TABLE users_b PARTITION OF users FOR VALUES FROM ('b') TO ('c');
CREATE TABLE users_c PARTITION OF users FOR VALUES FROM ('c') TO ('d');
CREATE TABLE users_d PARTITION OF users FOR VALUES FROM ('d') TO ('e');
CREATE TABLE users_e PARTITION OF users FOR VALUES FROM ('e') TO ('f');
CREATE TABLE users_f PARTITION OF users FOR VALUES FROM ('f') TO ('g');
CREATE TABLE users_g PARTITION OF users FOR VALUES FROM ('g') TO ('h');
CREATE TABLE users_h PARTITION OF users FOR VALUES FROM ('h') TO ('i');
CREATE TABLE users_i PARTITION OF users FOR VALUES FROM ('i') TO ('j');
CREATE TABLE users_j PARTITION OF users FOR VALUES FROM ('j') TO ('k');
CREATE TABLE users_k PARTITION OF users FOR VALUES FROM ('k') TO ('l');
CREATE TABLE users_l PARTITION OF users FOR VALUES FROM ('l') TO ('m');
CREATE TABLE users_m PARTITION OF users FOR VALUES FROM ('m') TO ('n');
CREATE TABLE users_n PARTITION OF users FOR VALUES FROM ('n') TO ('o');
CREATE TABLE users_o PARTITION OF users FOR VALUES FROM ('o') TO ('p');
CREATE TABLE users_p PARTITION OF users FOR VALUES FROM ('p') TO ('q');
CREATE TABLE users_q PARTITION OF users FOR VALUES FROM ('q') TO ('r');
CREATE TABLE users_r PARTITION OF users FOR VALUES FROM ('r') TO ('s');
CREATE TABLE users_s PARTITION OF users FOR VALUES FROM ('s') TO ('t');
CREATE TABLE users_t PARTITION OF users FOR VALUES FROM ('t') TO ('u');
CREATE TABLE users_u PARTITION OF users FOR VALUES FROM ('u') TO ('v');
CREATE TABLE users_v PARTITION OF users FOR VALUES FROM ('v') TO ('w');
CREATE TABLE users_w PARTITION OF users FOR VALUES FROM ('w') TO ('x');
CREATE TABLE users_x PARTITION OF users FOR VALUES FROM ('x') TO ('y');
CREATE TABLE users_y PARTITION OF users FOR VALUES FROM ('y') TO ('z');
CREATE TABLE users_z PARTITION OF users FOR VALUES FROM ('z') TO (MAXVALUE);

CREATE INDEX idx_users_others_username ON users_others (username);
CREATE INDEX idx_users_a_username ON users_a (username);
CREATE INDEX idx_users_b_username ON users_b (username);
CREATE INDEX idx_users_c_username ON users_c (username);
CREATE INDEX idx_users_d_username ON users_d (username);
CREATE INDEX idx_users_e_username ON users_e (username);
CREATE INDEX idx_users_f_username ON users_f (username);
CREATE INDEX idx_users_g_username ON users_g (username);
CREATE INDEX idx_users_h_username ON users_h (username);
CREATE INDEX idx_users_i_username ON users_i (username);
CREATE INDEX idx_users_j_username ON users_j (username);
CREATE INDEX idx_users_k_username ON users_k (username);
CREATE INDEX idx_users_l_username ON users_l (username);
CREATE INDEX idx_users_m_username ON users_m (username);
CREATE INDEX idx_users_n_username ON users_n (username);
CREATE INDEX idx_users_o_username ON users_o (username);
CREATE INDEX idx_users_p_username ON users_p (username);
CREATE INDEX idx_users_q_username ON users_q (username);
CREATE INDEX idx_users_r_username ON users_r (username);
CREATE INDEX idx_users_s_username ON users_s (username);
CREATE INDEX idx_users_t_username ON users_t (username);
CREATE INDEX idx_users_u_username ON users_u (username);
CREATE INDEX idx_users_v_username ON users_v (username);
CREATE INDEX idx_users_w_username ON users_w (username);
CREATE INDEX idx_users_x_username ON users_x (username);
CREATE INDEX idx_users_y_username ON users_y (username);
CREATE INDEX idx_users_z_username ON users_z (username);

INSERT INTO users (username, email, first_name, last_name, username_first_char) VALUES
('alice', 'alice@example.com', 'Alice', 'Smith', 'a'),
('bob', 'bob@example.com', 'Bob', 'Johnson', 'b'),
('charlie', 'charlie@example.com', 'Charlie', 'Brown', 'c'),
('diana', 'diana@example.com', 'Diana', 'Wilson', 'd'),
('edward', 'edward@example.com', 'Edward', 'Davis', 'e'),
('fiona', 'fiona@example.com', 'Fiona', 'Miller', 'f'),
('george', 'george@example.com', 'George', 'Garcia', 'g'),
('helen', 'helen@example.com', 'Helen', 'Martinez', 'h'),
('ivan', 'ivan@example.com', 'Ivan', 'Lopez', 'i'),
('julia', 'julia@example.com', 'Julia', 'Anderson', 'j'),
('123user', '123@example.com', 'Number', 'User', '1'),
('Zach', 'zach@example.com', 'Zach', 'Upper', 'Z');