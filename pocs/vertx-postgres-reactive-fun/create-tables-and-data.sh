#!/bin/bash

echo "
 \c db;
CREATE TABLE users (
  id serial PRIMARY KEY,
  name VARCHAR ( 50 )
);
INSERT INTO users(name) VALUES ('Diego');
INSERT INTO users(name) VALUES ('Gandalfy');
INSERT INTO users(name) VALUES ('Melina');
" | psql -h 127.0.0.1 -d pqdb -U root -W