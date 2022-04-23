### Build
```bash
./mvnw clean install
```
### Thread Dump
List all PIDs
```bash
jcmd
```
Take a ThreaDump on a PID
```bash
jcmd 2827028 Thread.print 
```
