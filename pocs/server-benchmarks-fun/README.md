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

### Gatling reports

* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/nettysimulation-20230831101614369/index.html">Boot Netty 4</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/nettymonosimulation-20230901072503134/index.html">Boot Mono Netty 4</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/tomcatsimulation-20230831101829804/index.html">Boot Tomcat 10.1</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/undertowsimulation-20230831102016479/index.html">Boot Undertow</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/micronautsimulation-20230831102207513/index.html">Micronaut</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/quarkussimulation-20230831102413091/index.html">Quarkus</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/nodejsexpresssimulation-20230901061955293/index.html">NodeJS 20 Express</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/gosimulation-20230901071759216/index.html">Go 1.21</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/rustactixsimulation-20230901065954265/index.html">Rust 1.71 Actix</a>
* <a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/zigzapsimulation-20230901083939880/index.html">Zig 0.11 Zap</a>

### Throwing a little bit of Salt

Things that this should be doing to be better.

* Wram up
* Run on AWS
* Have 2 different machines for server and gatling
* Make more rounds with more users, 10k, 100k, 1M
* Have other uses cases like, read json from DB, read static file, persist data, etc...