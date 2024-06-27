#!/bin/bash

echo "use person; DROP TABLE person;" | mysql -uroot -ppass -h127.0.0.1 -P3325

echo "use person; CREATE TABLE IF NOT EXISTS person (
          id INT AUTO_INCREMENT PRIMARY KEY,
          first_name VARCHAR(255) NOT NULL,
          last_name VARCHAR(255) NOT NULL,
          version int NOT NULL DEFAULT 0,
          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
      ) ENGINE=INNODB;;" | mysql -uroot -ppass -h127.0.0.1 -P3325

./mvnw spring-boot:run

