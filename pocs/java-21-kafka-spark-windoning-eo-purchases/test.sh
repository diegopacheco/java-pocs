#!/bin/bash
echo "Creating 10 purchases for user1..."
curl -s http://localhost:8081/generate/10/user1
echo ""
echo "Creating 10 purchases for user2..."
curl -s http://localhost:8081/generate/10/user2
echo ""
echo "Creating 10 purchases for user3..."
curl -s http://localhost:8081/generate/10/user3
echo ""
sleep 2
echo "Total debt for user1:"
curl -s http://localhost:8081/total/user1
echo ""
echo "Total debt for user2:"
curl -s http://localhost:8081/total/user2
echo ""
echo "Total debt for user3:"
curl -s http://localhost:8081/total/user3
echo ""
