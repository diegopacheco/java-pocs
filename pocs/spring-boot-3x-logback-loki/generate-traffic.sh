#!/bin/bash

for i in {1..100}
do
  curl "http://localhost:8080/ok"
  curl "http://localhost:8080/error"
done