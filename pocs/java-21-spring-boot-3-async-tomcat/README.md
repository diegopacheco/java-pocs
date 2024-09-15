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
Blocking Mono Scheduler(BE)      ->  118.97  RPS (Benchmark 02)
Blocking @Async Scheduler        ->  99.76   RPS (Benchmark 01)
Blocking NoMono NoScheduler      ->  199.06  RPS (Benchmark 05)
Blocking @Async Scheduler FJCP   ->  11.00   RPS (Benchmark 06)
Non-Blocking Mono Scheduler(BE)  ->  8731.17 RPS (benchmark 03) 
Non-Blocking NoMono NoScheduler  ->  9376.80 RPS (benchmark 04)
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
Tomcat Config:
```java

```
Results:
```
❯ ./stress-benchmark-01.sh
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
Time taken for tests:   601.428 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      9660000 bytes
HTML transferred:       1680000 bytes
Requests per second:    99.76 [#/sec] (mean)
Time per request:       10023.796 [ms] (mean)
Time per request:       10.024 [ms] (mean, across all concurrent requests)
Transfer rate:          15.69 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   15 114.0      2    1072
Processing:  1006 9915 746.6  10002   10047
Waiting:     1005 9913 746.5  10000   10046
Total:       1013 9930 693.8  10004   11059

Percentage of the requests served within a certain time (ms)
  50%  10004
  66%  10005
  75%  10005
  80%  10005
  90%  10006
  95%  10007
  98%  10008
  99%  10009
 100%  11059 (longest request)
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
Tomcat Config:
```java

```
Results:
```
❯ ./stress-benchmark-02.sh
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
Time taken for tests:   504.346 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      9660000 bytes
HTML transferred:       1680000 bytes
Requests per second:    118.97 [#/sec] (mean)
Time per request:       8405.774 [ms] (mean)
Time per request:       8.406 [ms] (mean, across all concurrent requests)
Transfer rate:          18.70 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   16 115.9      2    1065
Processing:  1004 8261 1002.2   8002   18007
Waiting:     1004 8259 1002.1   8001   18003
Total:       1021 8276 973.7   8004   18012

Percentage of the requests served within a certain time (ms)
  50%   8004
  66%   8006
  75%   8997
  80%   9001
  90%   9004
  95%   9008
  98%  10006
  99%  11999
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
Tomcat Config:
```java

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

Concurrency Level:      2000
Time taken for tests:   6.872 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      9660000 bytes
HTML transferred:       1680000 bytes
Requests per second:    8731.17 [#/sec] (mean)
Time per request:       229.064 [ms] (mean)
Time per request:       0.115 [ms] (mean, across all concurrent requests)
Transfer rate:          1372.77 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  112 276.8     77    3157
Processing:    12  111  29.3    107     748
Waiting:       10   82  29.5     75     705
Total:         29  223 281.1    188    3507

Percentage of the requests served within a certain time (ms)
  50%    188
  66%    198
  75%    205
  80%    210
  90%    221
  95%    234
  98%   1160
  99%   1230
 100%   3507 (longest request)

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
Tomcat Config:
```java

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
Time taken for tests:   10.665 seconds
Complete requests:      100000
Failed requests:        0
Total transferred:      16100000 bytes
HTML transferred:       2800000 bytes
Requests per second:    9376.80 [#/sec] (mean)
Time per request:       533.231 [ms] (mean)
Time per request:       0.107 [ms] (mean, across all concurrent requests)
Transfer rate:          1474.28 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  224 156.3    208    3266
Processing:    76  296  84.2    270     884
Waiting:       53  219  85.4    186     858
Total:        192  520 161.5    494    3522

Percentage of the requests served within a certain time (ms)
  50%    494
  66%    516
  75%    531
  80%    541
  90%    565
  95%    604
  98%   1432
  99%   1485
 100%   3522 (longest request)
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
Tomcat Config:
```java

```
OS TCP queues
```
Tomcat - recv-Q: 0, send-q: 100
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
Time taken for tests:   301.421 seconds
Complete requests:      60000
Failed requests:        0
Total transferred:      9660000 bytes
HTML transferred:       1680000 bytes
Requests per second:    199.06 [#/sec] (mean)
Time per request:       5023.689 [ms] (mean)
Time per request:       5.024 [ms] (mean, across all concurrent requests)
Transfer rate:          31.30 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   17 116.7      3    1064
Processing:  1004 4955 374.3   5002    5034
Waiting:     1003 4953 374.1   4999    5025
Total:       1027 4971 328.4   5004    6062

Percentage of the requests served within a certain time (ms)
  50%   5004
  66%   5005
  75%   5005
  80%   5006
  90%   5007
  95%   5008
  98%   5015
  99%   5020
 100%   6062 (longest request)
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
Tomcat Config:
```java

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
Time taken for tests:   5456.134 seconds
Complete requests:      60000
Failed requests:        5
   (Connect: 0, Receive: 0, Length: 5, Exceptions: 0)
Total transferred:      9659195 bytes
HTML transferred:       1679860 bytes
Requests per second:    11.00 [#/sec] (mean)
Time per request:       90935.570 [ms] (mean)
Time per request:       90.936 [ms] (mean, across all concurrent requests)
Transfer rate:          1.73 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   13 112.0      0    1076
Processing:  1005 89826 79831.4  87014 5131898
Waiting:     1004 89828 79831.0  87014 5131898
Total:       1038 89838 79826.3  87015 5131898

Percentage of the requests served within a certain time (ms)
  50%  87015
  66%  88014
  75%  93018
  80%  94017
  90%  96018
  95%  104018
  98%  104019
  99%  104020
 100%  5131898 (longest request)

```

#### Extras

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
Tomcat Config:
```java

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
Requests per second:    8731.17 [#/sec] (mean)
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
Requests per second:    8077.45 [#/sec] (mean)
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
Requests per second:    7929.54 [#/sec] (mean)
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
Requests per second:    8578.92 [#/sec] (mean)
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
Requests per second:    8161.42 [#/sec] (mean)
```