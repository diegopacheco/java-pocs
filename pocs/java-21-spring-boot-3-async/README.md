### Build

```bash
./mvnw clean install
```

### Summary

```
Blocking Mono Scheduler(BE)      -> 117.80 RPS
Blocking @Asybc Scheduler        -> 99.77 RPS
Non-Blocking Mono Scheduler(BE)  -> 9109.52 RPS 
Non-Blocking NoMono              -> RPS
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

### Benchmark 02: Stress Mono Date Blocking Schedulers.boundedElastic()

Stress Test Config:
```bash
ab -n 60000 -c 1000 http://localhost:8080/stress-benchmark-02
```
Code:
```
Controller -> @GetMapping("/stress-benchmark-02")
Service    -> AsyncMonoService.getDateAsync().subscribeOn(Schedulers.boundedElastic())
```
Impl:
````java
public Mono<String> getDateAsync() {
    return Mono.fromCallable( () -> {
        try {
            // Simulate a long-running task
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Date().toString();
    });
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
Scheduler(Schedulers.boundedElastic()) Config:
```
Queue Size: 100 000
TTL: 60 seconds
size: 10 * Runtime.getRuntime().availableProcessors() // 120 in my machine
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

Document Path:          /stress-benchmark-02
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   509.341 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    117.80 [#/sec] (mean)
Time per request:       8489.009 [ms] (mean)
Time per request:       8.489 [ms] (mean, across all concurrent requests)
Transfer rate:          12.31 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    2   4.1      1      41
Processing:  1004 8275 1062.8   8001   18008
Waiting:     1004 8274 1062.8   8001   18006
Total:       1046 8277 1061.0   8003   18012

Percentage of the requests served within a certain time (ms)
  50%   8003
  66%   8005
  75%   8059
  80%   9000
  90%   9003
  95%   9006
  98%  11003
  99%  13004
 100%  18012 (longest request)
```

### Benchmark 03: Stress Non-Blocking Mono Date Schedulers.boundedElastic()

Stress Test Config:
```bash
ab -n 60000 -c 1000 -s 60 http://localhost:8080/stress-benchmark-03
```

**It was necessary** add timeout of 60s on stress client `-s 60` otherwise ab was crashing timing out and did not complete.

Code:
```
Controller -> @GetMapping("/stress-benchmark-03")
Service    -> NoBlockService.getDateAsync().subscribeOn(Schedulers.boundedElastic());
```
Impl:
````java
public Mono<String> getDateAsync() {
    return Mono.fromCallable( () -> {
        return new Date().toString();
    });
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
Scheduler(Schedulers.boundedElastic()) Config:
```
Queue Size: 100 000
TTL: 60 seconds
size: 10 * Runtime.getRuntime().availableProcessors() // 120 in my machine
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
❯ ./stress-benchmark-03.sh
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

Document Path:          /stress-benchmark-03
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   6.587 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    9109.52 [#/sec] (mean)
Time per request:       109.775 [ms] (mean)
Time per request:       0.110 [ms] (mean, across all concurrent requests)
Transfer rate:          951.87 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   41  10.0     42      62
Processing:    18   66  27.5     61     258
Waiting:       13   51  30.4     48     257
Total:         57  107  20.9    103     281

Percentage of the requests served within a certain time (ms)
  50%    103
  66%    108
  75%    111
  80%    114
  90%    123
  95%    138
  98%    183
  99%    211
 100%    281 (longest request)
```