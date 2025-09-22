### Build

```bash
./mvnw clean install
```

### Result

```bash
❯ ./test.sh
Testing Spring Boot Apache Pulsar Integration
1. Testing application health...
Greetings from Spring Boot with Apache Pulsar!
2. Clearing any existing messages...
Messages cleared
3. Sending test message 1...
Message sent: Hello Pulsar 1
4. Sending test message 2...
Message sent: Hello Pulsar 2
5. Sending test message 3...
Message sent: Testing Message Consumer
6. Waiting for messages to be consumed...
7. Retrieving consumed messages...
[
  "Hello Pulsar 1",
  "Hello Pulsar 2",
  "Testing Message Consumer"
]
Test completed successfully!
```