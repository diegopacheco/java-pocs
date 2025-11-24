#!/bin/bash
USER_ID=${1:-1}
echo "Purchase history for user${USER_ID}:"
curl -s http://localhost:8081/history/user${USER_ID}
echo ""
