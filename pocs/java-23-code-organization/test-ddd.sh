#!/bin/bash

set -e

BASE_URL="http://localhost:8081/api"

echo "🚀 Starting DDD API Tests"
echo "========================="

USER_ID=""
PREFERENCE_ID=""
TRANSACTION_ID=""

make_request() {
    local method=$1
    local url=$2
    local data=$3
    local description=$4
    
    echo
    echo "📡 $description"
    echo "   $method $url"
    
    if [ -n "$data" ]; then
        echo "   Data: $data"
        response=$(curl -s -X $method -H "Content-Type: application/json" -d "$data" "$url")
    else
        response=$(curl -s -X $method "$url")
    fi
    
    # Format response with jq and limit arrays to 1 record
    if echo "$response" | jq . >/dev/null 2>&1; then
        formatted_response=$(echo "$response" | jq 'if type == "array" then .[0:1] else . end')
        echo "   Response: $formatted_response"
    else
        echo "   Response: $response"
    fi

    # echo "$response"
}

extract_id() {
    local json=$1
    echo "$json" | jq -r '.id // empty' 2>/dev/null || echo "$json" | grep -o '"id":"[^"]*"' | cut -d'"' -f4
}

echo
echo "🔧 Testing User Management"
echo "=========================="

echo "Creating user..."
user_response=$(make_request "POST" "$BASE_URL/users" '{"name":"John Doe","email":"john.doe@example.com","address":"123 Main St"}' "Create User")
USER_ID=$(extract_id "$user_response")
echo "Created user with ID: $USER_ID"

make_request "GET" "$BASE_URL/users/$USER_ID" "" "Get User by ID"
make_request "GET" "$BASE_URL/users/email/john.doe@example.com" "" "Get User by Email"
make_request "GET" "$BASE_URL/users" "" "Get All Users (limited to 1)"
make_request "PUT" "$BASE_URL/users/$USER_ID" '{"name":"John Smith","address":"456 Oak Ave"}' "Update User"

echo
echo "🔧 Testing Preference Management"
echo "==============================="

echo "Creating preference..."
pref_response=$(make_request "POST" "$BASE_URL/preferences" "{\"userId\":\"$USER_ID\",\"isActive\":true,\"solVersion\":\"1.0.0\"}" "Create Preference")
PREFERENCE_ID=$(extract_id "$pref_response")
echo "Created preference with ID: $PREFERENCE_ID"

make_request "GET" "$BASE_URL/preferences/$PREFERENCE_ID" "" "Get Preference by ID"
make_request "GET" "$BASE_URL/preferences/user/$USER_ID" "" "Get Preferences by User ID (limited to 1)"
make_request "GET" "$BASE_URL/preferences/active" "" "Get Active Preferences (limited to 1)"
make_request "GET" "$BASE_URL/preferences/inactive" "" "Get Inactive Preferences (limited to 1)"
make_request "GET" "$BASE_URL/preferences" "" "Get All Preferences (limited to 1)"
make_request "PUT" "$BASE_URL/preferences/$PREFERENCE_ID" '{"isActive":false,"solVersion":"2.0.0"}' "Update Preference"

echo
echo "🔧 Testing Transaction Management"
echo "================================"

echo "Creating credit transaction..."
credit_response=$(make_request "POST" "$BASE_URL/transactions/credit" "{\"userId\":\"$USER_ID\",\"amount\":100.50,\"notes\":\"Initial deposit\"}" "Create Credit Transaction")
CREDIT_TRANSACTION_ID=$(extract_id "$credit_response")
echo "Created credit transaction with ID: $CREDIT_TRANSACTION_ID"

echo "Creating debit transaction..."
debit_response=$(make_request "POST" "$BASE_URL/transactions/debit" "{\"userId\":\"$USER_ID\",\"amount\":25.75,\"notes\":\"Purchase\"}" "Create Debit Transaction")
DEBIT_TRANSACTION_ID=$(extract_id "$debit_response")
echo "Created debit transaction with ID: $DEBIT_TRANSACTION_ID"

make_request "GET" "$BASE_URL/transactions/$CREDIT_TRANSACTION_ID" "" "Get Transaction by ID"
make_request "GET" "$BASE_URL/transactions/user/$USER_ID" "" "Get Transactions by User ID (limited to 1)"
make_request "GET" "$BASE_URL/transactions/user/$USER_ID/balance" "" "Get User Balance"
make_request "GET" "$BASE_URL/transactions/user/$USER_ID/type/credit" "" "Get Credit Transactions for User (limited to 1)"
make_request "GET" "$BASE_URL/transactions/user/$USER_ID/type/debit" "" "Get Debit Transactions for User (limited to 1)"
make_request "GET" "$BASE_URL/transactions/type/credit" "" "Get All Credit Transactions (limited to 1)"
make_request "GET" "$BASE_URL/transactions/type/debit" "" "Get All Debit Transactions (limited to 1)"
make_request "GET" "$BASE_URL/transactions" "" "Get All Transactions (limited to 1)"
make_request "PUT" "$BASE_URL/transactions/${CREDIT_TRANSACTION_ID}/notes" '{"notes":"Updated deposit note"}' "Update Transaction Notes"

echo
echo "🔧 Testing More Complex Scenarios"
echo "=================================="

echo "Creating second user..."
user2_response=$(make_request "POST" "$BASE_URL/users" '{"name":"Jane Smith","email":"jane.smith@example.com","address":"789 Pine St"}' "Create Second User")
USER2_ID=$(extract_id "$user2_response")
echo "Created second user with ID: $USER2_ID"

make_request "POST" "$BASE_URL/transactions/credit" "{\"userId\":\"$USER2_ID\",\"amount\":200.00,\"notes\":\"Second user deposit\"}" "Create Credit for Second User"
make_request "POST" "$BASE_URL/transactions/debit" "{\"userId\":\"$USER2_ID\",\"amount\":50.00,\"notes\":\"Second user purchase\"}" "Create Debit for Second User"
make_request "GET" "$BASE_URL/transactions/user/${USER2_ID}/balance" "" "Get Second User Balance"

pref2_response=$(make_request "POST" "$BASE_URL/preferences" "{\"userId\":\"$USER2_ID\",\"isActive\":false,\"solVersion\":\"0.9.0\"}" "Create Preference for Second User")
PREFERENCE2_ID=$(extract_id "$pref2_response")

make_request "GET" "$BASE_URL/users" "" "Get All Users (limited to 1)"
make_request "GET" "$BASE_URL/preferences/active" "" "Get All Active Preferences (limited to 1)"
make_request "GET" "$BASE_URL/preferences/inactive" "" "Get All Inactive Preferences (limited to 1)"
