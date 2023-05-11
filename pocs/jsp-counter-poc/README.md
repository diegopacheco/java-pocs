### POC

Show how to intercept all Servlet/JSP calls using a Generic Sauron Filter.

### Build 
```bash
./mvnw clean install 
```
### Run 
```
./run-tomcat-cargo-9x.sh
```
```
[INFO] [talledLocalContainer] May 10, 2023 8:36:05 PM org.apache.coyote.AbstractProtocol start
[INFO] [talledLocalContainer] INFO: Starting ProtocolHandler ["http-nio-8080"]
[INFO] [talledLocalContainer] May 10, 2023 8:36:05 PM org.apache.catalina.startup.Catalina start
[INFO] [talledLocalContainer] INFO: Server startup in [429] milliseconds
[INFO] [talledLocalContainer] Tomcat 9.0.74 started on port [8080]
[INFO] Press Ctrl-C to stop the container...
```
### Test it 
```
./test.sh
```
```
[INFO] [talledLocalContainer] HIT : /jsp-counter-poc - /jsp-counter-poc/b.jsp
[INFO] [talledLocalContainer] HIT : /jsp-counter-poc - /jsp-counter-poc/a.jsp
[INFO] [talledLocalContainer] HIT : /jsp-counter-poc - /jsp-counter-poc/
```