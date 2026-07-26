# Java 25 Floci AWS POC

Spring Boot 4.1.0 application using AWS SDK for Java v2 against Floci on Podman. It covers SQS, SNS, Kinesis Data Streams, Amazon MSK, and S3 with JSON HTTP APIs and Swagger UI.

## Stack

| Component | Version |
|---|---:|
| Java | 25 |
| Spring Boot | 4.1.0 |
| Maven container | 3.9.16 |
| AWS SDK for Java | 2.47.6 |
| springdoc OpenAPI | 3.0.3 |
| Floci | latest |

## Requirements

- Java 25 and Maven for local builds
- Podman 5 or newer
- podman-compose
- curl
- jq

On macOS, a Podman machine must exist. `start.sh` starts an existing stopped machine and resolves its rootless Podman socket. On Linux, the script uses `${XDG_RUNTIME_DIR}/podman/podman.sock`.

Floci mounts the Podman API socket because MSK launches a real Redpanda container. All services share the `floci-poc` Podman network.

The mounted socket lets Floci create and manage containers in the current user's rootless Podman engine. On SELinux systems, Floci runs with the `container_runtime_t` process type so SELinux remains enabled while permitting the socket connection. Only run this trusted Floci image with socket access.

## Start

```bash
./start.sh
```

The application uses port `8080` and Floci uses port `4566` when those ports are free. `start.sh` automatically selects the next free ports when either is occupied and prints the resulting application, Floci, and Swagger URLs. The selected ports are stored in `.poc-ports.json`, which `test.sh` reads automatically.

Specific host ports can be requested:

```bash
APP_PORT=18080 FLOCI_PORT=14567 ./start.sh
BASE_URL=http://localhost:18080 ./test.sh
```

Swagger UI:

The Swagger URL is printed by `start.sh`.

OpenAPI JSON:

The OpenAPI JSON uses `/v3/api-docs` under the printed application URL.

## Test every service

```bash
./test.sh
```

The script writes and reads each service through the application API, validates the JSON responses, and formats every response with `jq`.

## Stop

```bash
./stop.sh
```

Stopping an absent stack succeeds and returns `{"status":"already stopped"}`.

## APIs

Every write accepts:

```json
{
  "value": "text"
}
```

| Service | Write | Read | Behavior |
|---|---|---|---|
| SQS | `POST /api/sqs` | `GET /api/sqs` | Sends, receives, and deletes queue messages |
| SNS | `POST /api/sns` | `GET /api/sns` | Publishes to a topic and reads its raw SQS subscription delivery |
| Kinesis | `POST /api/kinesis` | `GET /api/kinesis` | Puts records and reads the stream from its first shard |
| S3 | `POST /api/s3` | `GET /api/s3` | Writes and reads `value.txt` |
| MSK | `POST /api/msk` | `GET /api/msk` | Creates and lists MSK clusters through the AWS control plane |

Amazon MSK separates its AWS control plane from the Kafka data plane. AWS SDK for Java v2 provides the MSK control-plane client, so the MSK endpoints create and list clusters with that client. Floci backs the created cluster with Redpanda through Podman.

Resources are created lazily and idempotently:

| Service | Resource |
|---|---|
| SQS | `poc-sqs` |
| SNS | `poc-sns` with `poc-sns-delivery` |
| Kinesis | `poc-kinesis` |
| S3 | `poc-s3/value.txt` |
| MSK | Name supplied in the write request |

## Local build

```bash
mvn clean package
```

The application defaults to `http://localhost:4566` when run outside the compose stack. Settings can be changed with `AWS_ENDPOINT`, `AWS_REGION`, `AWS_ACCESS_KEY_ID`, and `AWS_SECRET_ACCESS_KEY`.
