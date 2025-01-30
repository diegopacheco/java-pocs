### Build
```bash
./mvnw clean install
```

### Result

```bash
curl -i http://localhost:8080/find?langName=es
```

See the custom header is there
```bash
❯ curl -i http://localhost:8080/find?langName=es
HTTP/1.1 200
version: V1
Content-Type: text/plain;charset=UTF-8
Content-Length: 4
Date: Thu, 30 Jan 2025 07:08:17 GMT

Hola%
```

In exception case(404) the header is also enforced
```bash
curl -i http://localhost:8080/find?langName=it
```

```bash
❯ curl -i http://localhost:8080/find\?langName\=it
HTTP/1.1 404
version: V1
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 30 Jan 2025 07:11:31 GMT

{"timestamp":"2025-01-30T07:11:31.065+00:00","status":404,"error":"Not Found","path":"/find"}%
```