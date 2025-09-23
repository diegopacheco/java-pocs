### Build

```bash
./mvnw clean install
```

### Result

```bash
❯ ./test.sh
Testing Spring Session with Redis functionality...
Creating session with key=username, value=john
Session created with ID: 2f4b7c3f-b498-4793-8cc0-af3c9d936281
Getting session value for key=username
Session ID: 2f4b7c3f-b498-4793-8cc0-af3c9d936281, Key: username, Value: john
Creating another session with key=role, value=admin
Session created with ID: 2f4b7c3f-b498-4793-8cc0-af3c9d936281
Getting session value for key=role
Session ID: 2f4b7c3f-b498-4793-8cc0-af3c9d936281, Key: role, Value: admin
Getting detailed session info using Spring Session Repository:
Session ID: 2f4b7c3f-b498-4793-8cc0-af3c9d936281, Creation Time: 2025-09-23T06:43:07.401Z, Last Accessed: 2025-09-23T06:43:07.459Z, Max Inactive: PT30M
Listing all active sessions in Redis:
["spring:session:sessions:expires:2f4b7c3f-b498-4793-8cc0-af3c9d936281","spring:session:sessions:2f4b7c3f-b498-4793-8cc0-af3c9d936281"]
```