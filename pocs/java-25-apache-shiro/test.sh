#!/bin/bash

echo "=== Apache Shiro Authentication Tests ==="
echo

BASE_URL="http://localhost:8080"

echo "1. Testing login with root user (admin role):"
curl -X POST "$BASE_URL/auth/login" \
  -d "username=root&password=secret" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -c cookies.txt
echo -e "\n"

echo "2. Testing current user (should show logged in user):"
curl -X GET "$BASE_URL/auth/current" -b cookies.txt
echo -e "\n"

echo "3. Testing admin role check:"
curl -X GET "$BASE_URL/auth/role/admin" -b cookies.txt
echo -e "\n"

echo "4. Testing admin-only endpoint:"
curl -X GET "$BASE_URL/auth/admin/info" -b cookies.txt
echo -e "\n"

echo "5. Testing logout:"
curl -X POST "$BASE_URL/auth/logout" -b cookies.txt
echo -e "\n"

echo "6. Testing current user after logout:"
curl -X GET "$BASE_URL/auth/current" -b cookies.txt
echo -e "\n"

echo "7. Testing login with guest user:"
curl -X POST "$BASE_URL/auth/login" \
  -d "username=guest&password=guest" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -c cookies.txt
echo -e "\n"

echo "8. Testing guest role check:"
curl -X GET "$BASE_URL/auth/role/guest" -b cookies.txt
echo -e "\n"

echo "9. Testing admin role check for guest (should be false):"
curl -X GET "$BASE_URL/auth/role/admin" -b cookies.txt
echo -e "\n"

echo "10. Testing lonestarr user with schwartz role:"
curl -X POST "$BASE_URL/auth/login" \
  -d "username=lonestarr&password=vespa" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -c cookies.txt
echo -e "\n"

echo "11. Testing schwartz role check:"
curl -X GET "$BASE_URL/auth/role/schwartz" -b cookies.txt
echo -e "\n"

echo "12. Testing lightsaber permission:"
curl -X GET "$BASE_URL/auth/permission/lightsaber:wield" -b cookies.txt
echo -e "\n"

echo "13. Testing invalid login:"
curl -X POST "$BASE_URL/auth/login" \
  -d "username=invalid&password=invalid" \
  -H "Content-Type: application/x-www-form-urlencoded"
echo -e "\n"

echo "14. Testing basic endpoint (should work without authentication):"
curl -X GET "$BASE_URL/"
echo -e "\n"

rm -f cookies.txt
echo "Tests completed!"