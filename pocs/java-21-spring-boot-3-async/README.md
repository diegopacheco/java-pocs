### Build

```bash
./mvnw clean install
```


### Hardware

```
❯ neofetch
            .-/+oossssoo+/-.               diego@4winds 
        `:+ssssssssssssssssss+:`           ------------ 
      -+ssssssssssssssssssyyssss+-         OS: Ubuntu 22.04.4 LTS x86_64 
    .ossssssssssssssssssdMMMNysssso.       Host: Avell G1555 MUV / A62 MUV Standard 
   /ssssssssssshdmmNNmmyNMMMMhssssss/      Kernel: 6.2.0-1009-lowlatency 
  +ssssssssshmydMMMMMMMNddddyssssssss+     Uptime: 9 days, 20 hours, 54 mins 
 /sssssssshNMMMyhhyyyyhmNMMMNhssssssss/    Packages: 4483 (dpkg), 274 (brew), 7 (flatpak), 43 (snap) 
.ssssssssdMMMNhsssssssssshNMMMdssssssss.   Shell: zsh 5.8.1 
+sssshhhyNMMNyssssssssssssyNMMMysssssss+   Resolution: 3840x2160 
ossyNMMMNyMMhsssssssssssssshmmmhssssssso   DE: GNOME 42.9 
ossyNMMMNyMMhsssssssssssssshmmmhssssssso   WM: Mutter 
+sssshhhyNMMNyssssssssssssyNMMMysssssss+   WM Theme: Adwaita 
.ssssssssdMMMNhsssssssssshNMMMdssssssss.   Theme: Yaru-blue [GTK2/3] 
 /sssssssshNMMMyhhyyyyhdNMMMNhssssssss/    Icons: Yaru-blue [GTK2/3] 
  +sssssssssdmydMMMMMMMMddddyssssssss+     Terminal: gnome-terminal 
   /ssssssssssshdmNNNNmyNMMMMhssssss/      CPU: Intel i7-9750H (12) @ 4.500GHz 
    .ossssssssssssssssssdMMMNysssso.       GPU: Intel CoffeeLake-H GT2 [UHD Graphics 630] 
      -+sssssssssssssssssyyyssss+-         GPU: NVIDIA GeForce GTX 1660 Ti Mobile 
        `:+ssssssssssssssssss+:`           Memory: 53173MiB / 64150MiB 
            .-/+oossssoo+/-.
```

### Summary

```
Blocking Mono Scheduler(BE)      -> 117.80  RPS (Benchmark 02)
Blocking @Async Scheduler        -> 99.77   RPS (Benchmark 01)
Blocking NoMono NoScheduler      -> 11.99   RPS (Benchmark 05)
Blocking @Async Scheduler FJCP   -> 10.99   RPS (Benchmark 06)
Non-Blocking Mono Scheduler(BE)  -> 9109.52 RPS (benchmark 03) 
Non-Blocking NoMono NoScheduler  -> 7462.38 RPS (benchmark 04)
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

### Benchmark 04: Stress Non-Blocking NoMono NoScheduler Date

Stress Test Config:
```bash
ab -n 60000 -c 1000 http://localhost:8080/stress-benchmark-04
```
Code:
```
Controller -> @GetMapping("/stress-benchmark-04")
Service    -> NoBlockService.getDate()
```
Impl:
````java
public String getDate() {
  return new Date().toString();
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
NO Schedulers
```
NONE
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
❯ ./stress-benchmark-04.sh
This is ApacheBench, Version 2.3 <$Revision: 1879490 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 10000 requests
Completed 20000 requests
Completed 30000 requests
Completed 40000 requests
Completed 50000 requests
Completed 60000 requests
Completed 70000 requests
Completed 80000 requests
Completed 90000 requests
Completed 100000 requests
Finished 100000 requests


Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /stress-benchmark-04
Document Length:        28 bytes

Concurrency Level:      5000
Time taken for tests:   13.401 seconds
Complete requests:      100000
Failed requests:        0
Total transferred:      10700000 bytes
HTML transferred:       2800000 bytes
Requests per second:    7462.38 [#/sec] (mean)
Time per request:       670.028 [ms] (mean)
Time per request:       0.134 [ms] (mean, across all concurrent requests)
Transfer rate:          779.76 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  270 140.2    223     754
Processing:    94  383 210.5    294    1094
Waiting:       73  280 166.2    203     875
Total:        283  653 320.2    521    1763

Percentage of the requests served within a certain time (ms)
  50%    521
  66%    560
  75%    598
  80%    710
  90%   1358
  95%   1463
  98%   1583
  99%   1637
 100%   1763 (longest request)
```

### Benchmark 05: Stress Blocking NoMono NoScheduler Date

Stress Test Config:
```bash
ab -n 60000 -c 1000 http://localhost:8080/stress-benchmark-05
```
Code:
```
Controller -> @GetMapping("/stress-benchmark-05")
Service    -> BlockService.getDateBlock();
```
Impl:
````java
public String getDateBlock() {
    // Simulate a long-running task
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    return new Date().toString();
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
NO Schedulers
```
NONE
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
OS TCP queues
```
Netty - recv-Q: 987, send-q: 40000
```
Results:
```
❯ ./stress-benchmark-05.sh
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

Document Path:          /stress-benchmark-05
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   5005.869 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    11.99 [#/sec] (mean)
Time per request:       83431.158 [ms] (mean)
Time per request:       83.431 [ms] (mean, across all concurrent requests)
Transfer rate:          1.25 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   4.9      0      53
Processing:  1209 82724 5647.7  83076   84135
Waiting:     1005 82720 5685.2  83076   84134
Total:       1209 82725 5643.0  83077   84153

Percentage of the requests served within a certain time (ms)
  50%  83077
  66%  83095
  75%  84075
  80%  84075
  90%  84077
  95%  84079
  98%  84083
  99%  84087
 100%  84153 (longest request)
```

### Benchmark 06: Stress @Async Blocking Scheduler Async ForkJoin.commonPool() Date

Stress Test Config:
```bash
ab -n 60000 -c 1000 http://localhost:8080/stress-benchmark-06
```
Code:
```
Controller -> @GetMapping("/stress-benchmark-06")
Service    -> AsyncService.getDateAsyncReallyAsync();
```
Impl:
````java
@Async("taskExecutor")
public CompletableFuture<String> getDateAsyncReallyAsync() {
    return CompletableFuture.supplyAsync(() -> {
        // Simulate a long-running task
        try {
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
NO Schedulers
```
NONE
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
❯ ./stress-benchmark-06.sh
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

Document Path:          /stress-benchmark-06
Document Length:        28 bytes

Concurrency Level:      1000
Time taken for tests:   5457.153 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      6420000 bytes
HTML transferred:       1680000 bytes
Requests per second:    10.99 [#/sec] (mean)
Time per request:       90952.550 [ms] (mean)
Time per request:       90.953 [ms] (mean, across all concurrent requests)
Transfer rate:          1.15 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   4.4      0      43
Processing:  1013 90174 99071.3  86015 4341772
Waiting:     1013 90173 99071.3  86014 4341772
Total:       1056 90174 99071.0  86015 4341772

Percentage of the requests served within a certain time (ms)
  50%  86015
  66%  89012
  75%  90016
  80%  91017
  90%  96015
  95%  100018
  98%  100020
  99%  112018
 100%  4341772 (longest request)
```

#### Extras

##### Netty Event Loops

Stress Test Config:
```bash
ab -n 60000 -c 1000 -s 60 http://localhost:8080/stress-benchmark-03
```
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
Netty Config:
```java
@Bean
public HttpServer httpServer() {
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

IOUringEventLoopGroup
```java
IOUringEventLoopGroup loopResources = new IOUringEventLoopGroup(48);
```
```
Requests per second:    9109.52 [#/sec] (mean)
```

NioEventLoopGroup
```java
NioEventLoopGroup loopResources = new NioEventLoopGroup(48);
```
```
Requests per second:    8771.94 [#/sec] (mean)
```

EpollEventLoopGroup
```java
EpollEventLoopGroup loopResources = new EpollEventLoopGroup(48);
```
```
Requests per second:    8959.57 [#/sec] (mean)
```

##### JVM GC

Stress Test Config:
```bash
ab -n 60000 -c 1000 -s 60 http://localhost:8080/stress-benchmark-03
```
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

Client/Stress:
```
ulimit -n 65535
```
Server:
```
ulimit -n 65535
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

ZGC
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
```
Requests per second:    9109.52 [#/sec] (mean)
```

G1
```
-XX:+UseG1GC \
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
```
Requests per second:    4740.74 [#/sec] (mean)
```

Shenandoah
```
-XX:+UseShenandoahGC \
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
```
Requests per second:    8037.97 [#/sec] (mean)
```

Parallel
```
-XX:+UseParallelGC \
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
```
Requests per second:    7897.80 [#/sec] (mean)
```

Epsilon
```
-XX:+UnlockExperimentalVMOptions \
-XX:+UseEpsilonGC \
-Xms8G \
-Xmx8G \
-XX:MaxGCPauseMillis=200 \
-XX:+OptimizeStringConcat \
-XX:+UseCompressedOops \
-XX:+AlwaysPreTouch \
-XX:+UseNUMA \
-XX:+DisableExplicitGC
```
```
Requests per second:    8595.45 [#/sec] (mean)
```

### Optimization Reverse Funnel

<img src="optimization-reverse-funnel.png" width="80%" />

Important classes
* https://github.com/netty/netty/blob/2b7de5a50bb3feb1a351dcd1ce1da9474ae256ae/transport/src/main/java/io/netty/channel/socket/DefaultServerSocketChannelConfig.java#L45
* https://github.com/netty/netty/blob/2b7de5a50bb3feb1a351dcd1ce1da9474ae256ae/common/src/main/java/io/netty/util/NetUtil.java#L170
* https://github.com/netty/netty/blob/2b7de5a50bb3feb1a351dcd1ce1da9474ae256ae/transport/src/main/java/io/netty/channel/nio/NioEventLoopGroup.java#L151
* https://github.com/netty/netty/blob/2b7de5a50bb3feb1a351dcd1ce1da9474ae256ae/common/src/main/java/io/netty/util/concurrent/SingleThreadEventExecutor.java#L50

