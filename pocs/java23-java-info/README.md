### Build
```bash
./mvnw clean install
```
### Result
```
curl -i http://localhost:8080/info
```
```
❯ curl -i http://localhost:8080/info
HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 39
Date: Fri, 20 Sep 2024 17:29:40 GMT

OpenJDK Runtime Environment
23 23+37-FR%  
```