### Build 
```bash
./mvnw clean install 
```
### Run toxiproxy server - CLI Version (Optitional) since java client does that already
```bash
./toxiproxy-server-linux-amd64 
``` 
Add proxy rules
```bash
toxiproxy-cli-linux-amd64 create -l localhost:26379 -u localhost:6379 redis
```
Add 1s latency per ops (since the app does 2 calls: SET and GET will take 2 seconds) 
```bash
toxiproxy-cli-linux-amd64 toxic add -t latency -a latency=1000 redis 
```
### Run 
```
