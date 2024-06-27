#!/bin/bash

echo "calling [http://127.0.0.1:8080/save/0/john/doe/0] should be insert! OK."
curl -i "http://127.0.0.1:8080/save/0/john/doe/0" -H "accept: application/json" -d ""

echo "calling [http://127.0.0.1:8080/save/6/john/doe/1] should be update! OK."
curl -i "http://127.0.0.1:8080/save/6/john/doe/1" -H "accept: application/json" -d ""

echo "calling [http://127.0.0.1:8080/save/6/john/doe/1] should be update! BAM! Does not work!"
curl -i "http://127.0.0.1:8080/save/6/john/doe/1" -H "accept: application/json" -d ""
