#!/usr/bin/env bash
set -euo pipefail
BASE="${BASE_URL:-http://localhost:8080}"
suffix="$(date +%s)"

field() {
  python3 -c "import sys,json;print(json.load(sys.stdin)$1)"
}

register() {
  curl -sf -X POST "$BASE/api/auth/register" -H 'Content-Type: application/json' \
    -d "{\"username\":\"$1\",\"password\":\"pw\",\"displayName\":\"$2\"}"
}

alice="$(register "alice$suffix" "Alice")"
atoken="$(echo "$alice" | field "['token']")"

bob="$(register "bob$suffix" "Bob")"
btoken="$(echo "$bob" | field "['token']")"
bid="$(echo "$bob" | field "['user']['id']")"

channel="$(curl -sf -X POST "$BASE/api/channels" -H "Authorization: Bearer $atoken" -H 'Content-Type: application/json' \
  -d '{"name":"general","type":"PUBLIC","memberIds":[]}')"
cid="$(echo "$channel" | field "['id']")"

curl -sf -X POST "$BASE/api/channels/$cid/join" -H "Authorization: Bearer $btoken" >/dev/null

curl -sf -X POST "$BASE/api/channels/$cid/messages" -H "Authorization: Bearer $atoken" -H 'Content-Type: application/json' \
  -d "{\"content\":\"hello @bob$suffix welcome aboard\",\"attachments\":[]}" >/dev/null

history="$(curl -sf "$BASE/api/channels/$cid/messages" -H "Authorization: Bearer $btoken")"
echo "$history" | grep -q "hello @bob$suffix" || { echo "FAIL: message missing from history"; exit 1; }

notifs="$(curl -sf "$BASE/api/notifications" -H "Authorization: Bearer $btoken")"
echo "$notifs" | grep -q "MENTION" || { echo "FAIL: mention notification missing"; exit 1; }

dm="$(curl -sf -X POST "$BASE/api/dms/$bid" -H "Authorization: Bearer $atoken")"
dmid="$(echo "$dm" | field "['id']")"

curl -sf -X POST "$BASE/api/channels/$dmid/messages" -H "Authorization: Bearer $atoken" -H 'Content-Type: application/json' \
  -d '{"content":"hi bob this is a direct message","attachments":[]}' >/dev/null

dmnotifs="$(curl -sf "$BASE/api/notifications" -H "Authorization: Bearer $btoken")"
echo "$dmnotifs" | grep -q "DIRECT_MESSAGE" || { echo "FAIL: direct message notification missing"; exit 1; }

echo "PASS: register, channel create, join, send, history, mention, dm open, dm notification"
