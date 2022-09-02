#!/bin/bash

docker run --rm --name oracle -d -p 1521:1521 -e ORACLE_PASSWORD=1234 gvenzl/oracle-xe