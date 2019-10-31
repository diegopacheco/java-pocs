#!/bin/bash

echo "CREATE DATABASE poc;" | docker run --network host -i postgres psql -h localhost -U postgres
