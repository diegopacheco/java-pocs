#!/bin/bash

echo "CREATE DATABASE db;" | psql -h 127.0.0.1 -d pqdb -U root -W