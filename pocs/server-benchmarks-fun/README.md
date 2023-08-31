### Servers on the Benchmark

* Tomcat 10.1
* Netty 4
* Undertow
* Micronaut
* Quarkus

### Results

1k users, during 1 minute non-stop
* Boot-Netty    : 60000 total/OK, p99: 2 ms 
* Boot-Tomcat   : 60000 total/OK, p99: 6 ms
* Boot-Undertow : 60000 total/OK, p99: 15 ms
* Micronaut     : 60000 total/OK, p99: 129 ms
* Quarkus       : 60000 total/OK, p99: 4 ms 

### build
```bash
./mvnw clean install
```
