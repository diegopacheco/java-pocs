### Build 
```bash
./mvnw clean install 
```
### Run server
```bash
./run.sh
```
### test via telnet
```bash
telnet 127.0.0.1 9000
<time/>
<options/>
<quit/>
```
### TCP Dump
```bash
sudo tcpdump -i lo -A -s 0 tcp port 9000 -w server.pcap 
```
