### Build

```bash
./mvnw clean install
```

### Summary

```
Block Mono          -> RPS
Block Scheduler     -> 99.77 RPS
Non-Blocking Mono   -> RPS 
Non-Blocking NoMono -> RPS
```
<br/>

**Big Call out**: This is running all in one machine. Server and client(stress) should be in different machines due 
to cpu and memory contention.

### Benchmark 01: Stress @Async Date Scheduler CompletableFuture

Stress Test Config: 
```bash
ab -n 60000 -c 1000 http://localhost:8080/stress-benchmark-01
```
Code:
```
Controller -> @GetMapping("/stress-benchmark-01")
Service    -> AsyncDateService.getDateAsync
```
Impl:
````java
@Async("taskExecutor")
public CompletableFuture<String> getDateAsync() {
    // Simulate a long-running task
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    return CompletableFuture.completedFuture(new Date().toString());
}
````
Specs

Server JVM
```
-XX:+UseZGC \
-Xms8G \
-Xmx8G \
-XX:MaxGCPauseMillis=200 \
-XX:+UseStringDeduplication \
-XX:+OptimizeStringConcat \
-XX:+UseCompressedOops \
-XX:+AlwaysPreTouch \
-XX:+UseNUMA \
-XX:+DisableExplicitGC
```
Client/Stress:
```
ulimit -n 65535
```
Server:
```
ulimit -n 65535
```
Scheduler Config:
```java
@Bean(name = "taskExecutor")
public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(100);
    executor.setMaxPoolSize(200);
    executor.setQueueCapacity(1000);
    executor.setThreadNamePrefix("AsyncThread-");
    executor.setDaemon(true);
    executor.initialize();
    return executor;
}
```
Netty Config:
```java
@Bean
public HttpServer httpServer() {
    IOUringEventLoopGroup loopResources = new IOUringEventLoopGroup(48);
    return HttpServer.create()
            .runOn(loopResources)
            .option(ChannelOption.SO_BACKLOG, 128)
            .option(ChannelOption.TCP_FASTOPEN, 1024)
            .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
            .childOption(ChannelOption.SO_KEEPALIVE, true)
            .childOption(ChannelOption.TCP_NODELAY, true)
            .childOption(ChannelOption.SO_RCVBUF, 1 * 1024 * 1024)  // 1 MB receive buffer
            .childOption(ChannelOption.SO_SNDBUF, 1 * 1024 * 1024); // 1 MB send buffer
}
```
Results:
```
This is ApacheBench, Version 2.3 <$Revision: 1879490 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 6000 requests
Completed 12000 requests
Completed 18000 requests
Completed 24000 requests
Completed 30000 requests
Completed 36000 requests
Completed 42000 requests
Completed 48000 requests
Completed 54000 requests
Completed 60000 requests
Finished 60000 requests


Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /stress-benchmark-01
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   601.381 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    99.77 [#/sec] (mean)
Time per request:       10023.021 [ms] (mean)
Time per request:       10.023 [ms] (mean, across all concurrent requests)
Transfer rate:          10.43 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    3   4.2      2      39
Processing:  1007 9926 683.7  10001   10292
Waiting:     1006 9925 683.6  10000   10291
Total:       1046 9929 680.4  10003   10292

Percentage of the requests served within a certain time (ms)
  50%  10003
  66%  10004
  75%  10004
  80%  10004
  90%  10006
  95%  10007
  98%  10009
  99%  10012
 100%  10292 (longest request)
```
