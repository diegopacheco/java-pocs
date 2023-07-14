### Build 
```bash
./mvnw clean install 
```
### Run Splunk in Podman
```bash
./run-splunk-podman.sh
```
Goto: 127.0.0.1:8000 on the browser
1. Create an Data Input (Settings -> Data Inputs -> HTTP Event Collector -> Add New)
2. Make sure you dont mark: Enable indexer acknowledgement
3. Copy the token at the end i.e: 5086f1e1-2bfd-4352-9b3f-cb11fcfcf099
4. This token needs to go on log4j2.xml
### Sending data via curl
```bash
curl https://127.0.0.1:8088/services/collector/event -H "Authorization: Splunk 5086f1e1-2bfd-4352-9b3f-cb11fcfcf099" -d '{"event": "hello world"}' -k
```
```bash
{"text":"Success","code":0}
```
Go to: http://127.0.0.1:8000/en-US/app/search/search
```bash
index="history" hello
```