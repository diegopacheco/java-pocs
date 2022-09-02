#!/bin/bash

docker exec -i oracle bash << EOF
sqlplus -s /nolog
connect system/1234@XE
CREATE SCHEMA AUTHORIZATION system;
commit;
CREATE TABLE system.contact (id number PRIMARY KEY,name VARCHAR2(32),email VARCHAR2(32),phone VARCHAR2(32));
commit;
INSERT INTO system.contact VALUES (1, 'di', 'di@e.com', '12345');
commit;
describe system.contact;
select * FROM system.contact;
exit
EOF