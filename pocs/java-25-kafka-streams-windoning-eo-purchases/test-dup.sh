#!/bin/bash
echo "Creating 5 duplicate purchases for user1 (same purchaseId)..."
curl -s http://localhost:8081/duplicate/5/user1
echo ""
echo "Creating 5 duplicate purchases for user2 (same purchaseId)..."
curl -s http://localhost:8081/duplicate/5/user2
echo ""
echo "Creating 5 duplicate purchases for user3 (same purchaseId)..."
curl -s http://localhost:8081/duplicate/5/user3
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
