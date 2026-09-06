#!/bin/bash
cd "$(dirname "$0")"

PORT=8081
BASE="http://localhost:${PORT}"
WAR="target/big-decimal-facts-1.0-SNAPSHOT.war"
LOG="target/endpoints-app.log"
PASS=0
FAIL=0
APP_PID=""

stop_app() {
  if [ -n "$APP_PID" ] && kill -0 "$APP_PID" 2>/dev/null; then
    kill "$APP_PID" 2>/dev/null
    wait "$APP_PID" 2>/dev/null
  fi
}
trap stop_app EXIT

call() {
  local method="$1"
  local path="$2"
  local body="$3"
  local raw
  if [ -n "$body" ]; then
    raw=$(curl -s -w '\n%{http_code}' -X "$method" -H 'Content-Type: application/json' -d "$body" "${BASE}${path}")
  else
    raw=$(curl -s -w '\n%{http_code}' -X "$method" "${BASE}${path}")
  fi
  STATUS=$(echo "$raw" | tail -n 1)
  BODY=$(echo "$raw" | sed '$d')
}

check() {
  local desc="$1"
  local expected="$2"
  local actual="$3"
  if [[ "$actual" == *"$expected"* ]]; then
    PASS=$((PASS + 1))
    echo "PASS ${desc}"
  else
    FAIL=$((FAIL + 1))
    echo "FAIL ${desc}"
    echo "     expected: ${expected}"
    echo "     actual:   ${actual}"
  fi
}

echo "building"
./mvnw -q clean package -DskipTests || exit 1

echo "starting application on port ${PORT}"
java -jar "$WAR" --server.port=${PORT} > "$LOG" 2>&1 &
APP_PID=$!

READY=0
for i in $(seq 1 60); do
  if curl -s "${BASE}/actuator/health" | grep -q '"status":"UP"'; then
    READY=1
    break
  fi
  if ! kill -0 "$APP_PID" 2>/dev/null; then
    break
  fi
  sleep 1
done

if [ "$READY" -ne 1 ]; then
  echo "application did not start, see ${LOG}"
  tail -n 40 "$LOG"
  exit 1
fi

echo "running endpoint checks"

call POST /ledger/transfers '{"id":"e1","from":"alice","to":"bob","amount":"25.50","currency":"USD","description":"rent"}'
check "transfer returns 200" "200" "$STATUS"
check "transfer amount stays a string" '"amount":"25.50"' "$BODY"
check "transfer carries minor units" '"minorUnits":2550' "$BODY"
check "transfer debits the sender" '"amount":"-25.50"' "$BODY"
check "transfer entry balances" '"residual":{"amount":"0.00"' "$BODY"

call GET '/ledger/accounts/alice/balance?currency=USD'
check "sender balance is exact" '"amount":"-25.50"' "$BODY"
call GET '/ledger/accounts/bob/balance?currency=USD'
check "receiver balance is exact" '"amount":"25.50"' "$BODY"

call POST /ledger/sales '{"id":"e2","customer":"customer","revenue":"revenue","taxAccount":"tax-payable","net":"19.99","currency":"USD","taxRate":"0.0825","rounding":"HALF_UP"}'
check "sale returns 200" "200" "$STATUS"
check "tax is rounded once to 1.65" '"amount":"1.65"' "$BODY"
check "customer owes 21.64" '"amount":"-21.64"' "$BODY"
check "sale entry balances" '"residual":{"amount":"0.00"' "$BODY"

call POST /ledger/transfers-with-fee '{"id":"e3","from":"payer","to":"payee","feeAccount":"fees","gross":"100.00","currency":"USD","feeRate":"0.029","rounding":"HALF_UP"}'
check "fee transfer returns 200" "200" "$STATUS"
check "fee is 2.90" '"amount":"2.90"' "$BODY"
check "net credited is 97.10" '"amount":"97.10"' "$BODY"
check "fee entry balances" '"residual":{"amount":"0.00"' "$BODY"

call POST /ledger/distributions '{"id":"e4","from":"pool","recipients":["ann","ben","cid"],"total":"10.00","currency":"USD"}'
check "distribution returns 200" "200" "$STATUS"
check "remainder cent is handed out" '"amount":"3.34"' "$BODY"
check "other slices are 3.33" '"amount":"3.33"' "$BODY"
check "distribution balances" '"residual":{"amount":"0.00"' "$BODY"

call POST /ledger/transfers '{"id":"e5","from":"alice","to":"bob","amount":"1.005","currency":"USD","description":"sub cent"}'
check "sub cent amount is rejected" "400" "$STATUS"

call POST /ledger/sales '{"id":"e6","customer":"customer","revenue":"revenue","taxAccount":"tax-payable","net":"19.99","currency":"USD","taxRate":"0.0825"}'
check "missing rounding mode is rejected" "400" "$STATUS"

call POST /ledger/transfers '{"id":"e7","from":"alice","to":"bob","amount":"1.00","currency":"USD","description":"replay"}'
check "first post accepted" "200" "$STATUS"
call POST /ledger/transfers '{"id":"e7","from":"alice","to":"bob","amount":"1.00","currency":"USD","description":"replay"}'
check "replayed entry is rejected" "409" "$STATUS"

call POST /ledger/transfers '{"id":"e8","from":"tokyo-payer","to":"tokyo-payee","amount":"100","currency":"JPY","description":"yen"}'
check "yen has no minor unit split" '"minorUnits":100' "$BODY"
check "yen amount has no decimals" '"amount":"100"' "$BODY"

call GET '/ledger/accounts/bob/balance?currency=JPY'
check "cross currency balance read is rejected" "400" "$STATUS"

for i in $(seq 1 100); do
  call POST /ledger/transfers "{\"id\":\"micro-${i}\",\"from\":\"micro-payer\",\"to\":\"micro-payee\",\"amount\":\"0.07\",\"currency\":\"USD\",\"description\":\"micro\"}"
done
call GET '/ledger/accounts/micro-payee/balance?currency=USD'
check "one hundred postings of 0.07 total exactly 7.00" '"amount":"7.00"' "$BODY"
check "balance minor units are exact" '"minorUnits":700' "$BODY"

call GET /ledger/journal
check "journal returns the posted entries" '"id":"e1"' "$BODY"

echo "passed: ${PASS}"
echo "failed: ${FAIL}"
[ "$FAIL" -eq 0 ]
