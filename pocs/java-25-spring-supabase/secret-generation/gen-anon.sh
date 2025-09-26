#!/bin/bash

node -e "const jwt=require('jsonwebtoken');console.log(jwt.sign(
  { role:'anon', aud:'authenticated', iss:'supabase' },
  'super-secret-jwt-token-with-at-least-32-characters-long',
  { expiresIn:'10y' }
));" >anon.key
