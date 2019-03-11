#!/bin/bash

export VAULT_ADDR='http://127.0.0.1:8200'

vault kv put secret/rds/dev/ user.pass=? jdbc.url=jdbc:mysql://test-db.?.us-east-1.rds.amazonaws.com:3306/test

vault kv get secret/rds/dev/
