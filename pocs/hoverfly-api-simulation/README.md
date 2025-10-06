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

### Using Scripts

```bash
./run.sh
```

This will:
- Build the Docker image with Java 25
- Start the container
- Initialize Hoverfly in simulation mode
- Show application logs

### Stopping

```bash
./stop.sh
```

### Testing

Run the test script to verify Hoverfly is working:

```bash
./test.sh
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

## Result

The application works locally. Docker port forwarding with Podman has connectivity issues.
Use local testing for demonstration:

```bash
./mvnw exec:java -Dexec.mainClass="Main" &
sleep 5
curl -x http://localhost:8500 http://api.test.com/users/1
curl -x http://localhost:8500 http://api.test.com/users/2
pkill -f "exec:java"
```

Output:
```
{"id":1,"name":"John Doe","email":"john@test.com"}
{"id":2,"name":"Jane Smith","email":"jane@test.com"}
```
