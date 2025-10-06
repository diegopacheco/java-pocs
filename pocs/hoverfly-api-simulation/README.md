# Hoverfly API Simulation POC

API simulation and service virtualization with Hoverfly using Java 25.

## What is Hoverfly?

Hoverfly is a lightweight service virtualization tool that allows you to simulate HTTP(S) services. It can operate as a proxy server, capturing and replaying HTTP traffic.

## Features

- Java 25 application using Hoverfly for API simulation
- Simulates REST API endpoints for user management
- Runs in Docker container using Podman
- Configured to run in SIMULATE mode (proxy-based)

## Simulated Endpoints

The POC simulates the following endpoints:

- `GET http://api.test.com/users/1` - Returns user John Doe
- `GET http://api.test.com/users/2` - Returns user Jane Smith
- `POST http://api.test.com/users` - Creates a new user

## Running the Application

### Local (Recommended)

```bash
./mvnw exec:java -Dexec.mainClass="Main"
```

The application will start Hoverfly and keep running.

Wait for the message: `Hoverfly is running. Press Ctrl+C to stop...`

Then in another terminal, test manually:
```bash
curl -4 -x http://127.0.0.1:8500 http://api.test.com/users/1
curl -4 -x http://127.0.0.1:8500 http://api.test.com/users/2
```

Note: Use `-4` flag and `127.0.0.1` because Hoverfly binds to IPv4 only.

Or use the test script (waits for Hoverfly to be ready):
```bash
./test.sh
```

### Using Docker (Optional)

```bash
./run.sh
```

This will:
- Build the Docker image with Java 25
- Start the container
- Initialize Hoverfly in simulation mode
- Show application logs

To stop:

```bash
./stop.sh
```

## How It Works

The application uses Hoverfly in SIMULATE mode, which acts as a proxy server. Requests must be routed through the proxy:

```bash
curl -x http://localhost:8500 http://api.test.com/users/1
```

## Ports

- `8888` - Hoverfly Admin UI
- `8500` - Hoverfly Proxy Port

## Local Testing (without Docker)

```bash
./mvnw exec:java -Dexec.mainClass="Main"
```

Then in another terminal:
```bash
curl -x http://localhost:8500 http://api.test.com/users/1
curl -x http://localhost:8500 http://api.test.com/users/2
```

## Technology Stack

- Java 25
- Hoverfly Java 0.18.1
- Apache HttpClient 5.4.1
- Maven
- Podman/Docker

## Build

```bash
./mvnw clean install
```

## Test Results

Terminal 1:
```bash
./mvnw exec:java -Dexec.mainClass="Main"
```

Output:
```
Hoverfly started in simulation mode
Admin UI: http://localhost:8888
Proxy Port: 8500

Simulated endpoints (use proxy):
  GET  http://api.test.com/users/1 (via proxy localhost:8500)
  GET  http://api.test.com/users/2 (via proxy localhost:8500)
  POST http://api.test.com/users (via proxy localhost:8500)

Testing simulation with proxy:
Response: {"id":1,"name":"John Doe","email":"john@test.com"}

Hoverfly is running. Press Ctrl+C to stop...
```

Terminal 2:
```bash
./test.sh
```

Output:
```
Waiting for Hoverfly to be ready...
Hoverfly is ready!

Testing Hoverfly API Simulation...

Test 1: GET /users/1 via proxy
{"id":1,"name":"John Doe","email":"john@test.com"}

Test 2: GET /users/2 via proxy
{"id":2,"name":"Jane Smith","email":"jane@test.com"}

All tests completed!
```
