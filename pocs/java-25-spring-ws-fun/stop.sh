#!/bin/bash
if [ -f .backend.pid ]; then
    kill $(cat .backend.pid) 2>/dev/null
    rm .backend.pid
    echo "Backend stopped"
else
    pkill -f "spring-boot:run" 2>/dev/null
    echo "Backend stopped"
fi
