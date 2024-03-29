### Build
```bash
./mvnw clean install
```
### Run
```
./run-httpbin.sh
```
```
❯ ./run-httpbin.sh
[2024-03-29 07:29:42 +0000] [1] [INFO] Starting gunicorn 19.9.0
[2024-03-29 07:29:42 +0000] [1] [INFO] Listening at: http://0.0.0.0:80 (1)
[2024-03-29 07:29:42 +0000] [1] [INFO] Using worker: gevent
[2024-03-29 07:29:42 +0000] [4] [INFO] Booting worker with pid: 4
```
goto: http://localhost:8082/ for httpbin swagger.
