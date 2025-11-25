#!/bin/bash
echo "Total debt for user1:"
curl -s http://localhost:8081/total/user1
echo ""
echo "Total debt for user2:"
curl -s http://localhost:8081/total/user2
echo ""
echo "Total debt for user3:"
curl -s http://localhost:8081/total/user3
echo ""
