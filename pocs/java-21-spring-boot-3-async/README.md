### Build
```bash
./mvnw clean install
```
### Summary

```
Block Mono          -> RPS
Block Scheduler     -> RPS
Non-Blocking Mono   -> RPS 
Non-Blocking NoMono -> RPS
```

### Benchmark 01: Stress @Async Date Scheduler CompletableFuture

Stress Test Config: 
```
ab -n 60000 -c 1000 http://localhost:8080/async-task
```
Code:
```
Controller -> @GetMapping("/stress-benchmark-01")
Service    -> AsyncDateService.getDateAsync
```
Impl:
````
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
Specs:
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
Results:
```

```
