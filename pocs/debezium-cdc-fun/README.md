### Debezium CDC Fun

Change Data Capture system with Debezium, Kafka, PostgreSQL, Spring Boot 3.5.5 (Java 23), and Go 1.25 consumer.

### Architecture

- **PostgreSQL 17**: Database with WAL enabled for CDC
- **Spring Boot 3.5.5**: Java 23 application with REST endpoints
- **Kafka 3.9.0**: Event streaming platform
- **Zookeeper 3.0**: Kafka coordination
- **Debezium Connect 3.0**: CDC connector
- **Go 1.25**: Kafka consumer printing CDC events

### Quick Start

```bash
./run.sh
```

This starts all containers with restart policies. Services may take 1-2 minutes to fully stabilize.

### Manual Setup (if needed)

If services don't stabilize automatically:

```bash
podman-compose up -d
podman ps
podman logs debezium-cdc-fun_kafka_1
```

Wait for Kafka to show: `started (kafka.server.KafkaServer)`

Then register the Debezium connector:

```bash
./setup-connector.sh
```

Or manually:

```bash
curl -i -X POST -H "Content-Type: application/json" \
  --data @debezium-connector.json \
  http://localhost:8083/connectors
```

### Test CDC Pipeline

```bash
./test.sh
```

Or manually:

```bash
curl http://localhost:8080/generate
podman logs debezium-cdc-fun_go-consumer_1
```

### Stop System

```bash
./stop.sh
```

### Endpoints

- Generate data: `http://localhost:8080/generate`
- Get all data: `http://localhost:8080/getdata`
- Debezium Connect: `http://localhost:8083`
- PostgreSQL: `localhost:5432` (postgres/postgres)

### Troubleshooting

Check individual service logs:

```bash
podman logs debezium-cdc-fun_app_1
podman logs debezium-cdc-fun_kafka_1
podman logs debezium-cdc-fun_debezium_1
podman logs debezium-cdc-fun_go-consumer_1
```

Restart specific service:

```bash
podman restart debezium-cdc-fun_kafka_1
```

### How It Works

1. Java app writes data to PostgreSQL
2. Debezium captures database changes via PostgreSQL WAL
3. Changes are streamed to Kafka topic `dbserver1.public.data_events`
4. Go consumer reads and prints CDC events from Kafka


