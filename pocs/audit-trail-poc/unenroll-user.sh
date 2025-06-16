#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Error: User ID must be provided"
    echo "Usage: $0 <user_id>"
    exit 1
fi

USER_ID=$1
BASE_URL="http://localhost:8080/api"

echo "Unenrolling user $USER_ID..."
UNENROLL_RESPONSE=$(curl -s -o /dev/null -w "%{http_code}" -X DELETE "${BASE_URL}/users/unenroll/${USER_ID}")

if [ $UNENROLL_RESPONSE -eq 204 ] || [ $UNENROLL_RESPONSE -eq 200 ]; then
    echo "User $USER_ID has been successfully unenrolled."
    exit 0
else
    echo "Error: Failed to unenroll user. Response code: $UNENROLL_RESPONSE"
    exit 1
fi