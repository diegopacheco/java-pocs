#!/usr/bin/env bash
set -euo pipefail
if [[ -n "${BASE_URL:-}" ]]; then
  base_url="${BASE_URL}"
elif [[ -f .poc-ports.json ]]; then
  base_url="http://localhost:$(jq -r '.appPort' .poc-ports.json)"
else
  base_url="http://localhost:8080"
fi
write() {
  service="$1"
  value="$2"
  response="$(curl --max-time 60 -fsS -X POST "${base_url}/api/${service}" -H "Content-Type: application/json" -d "{\"value\":\"${value}\"}")"
  jq . <<<"${response}"
  jq -e --arg service "${service}" '.service == $service and .id != null and .value != null' >/dev/null <<<"${response}"
}
read_value() {
  service="$1"
  response="$(curl --max-time 60 -fsS "${base_url}/api/${service}")"
  jq . <<<"${response}"
  jq -e --arg service "${service}" '.service == $service and (.values | type == "array")' >/dev/null <<<"${response}"
}
write sqs "sqs-value"
read_value sqs
write sns "sns-value"
read_value sns
write kinesis "kinesis-value"
read_value kinesis
write s3 "s3-value"
read_value s3
write msk "floci-msk"
read_value msk
jq -n --arg baseUrl "${base_url}" '{status: "passed", baseUrl: $baseUrl, services: ["sqs", "sns", "kinesis", "s3", "msk"]}'
