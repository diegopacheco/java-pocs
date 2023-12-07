### Build
```bash
./mvnw clean install
```
### Test ws on linux
```bash
❯ websocat ws://127.0.0.1:8080/user
```
```
joe 
```
```bash
ws got message: TextMessage payload=[joe ], byteCount=4, last=true]
```