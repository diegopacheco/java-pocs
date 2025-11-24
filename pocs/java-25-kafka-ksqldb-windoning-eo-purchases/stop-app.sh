#!/bin/bash
lsof -ti:8082 | xargs kill -9 2>/dev/null
sleep 1
echo "App stopped"
