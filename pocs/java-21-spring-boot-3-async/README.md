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

### Benchmark 01 - Stress Async Scheduler CompletableFuture

Stress Test Config: 
```
ab -n 60000 -c 1000 http://localhost:8080/async-task
```
Code:
```
Controller -> 
Service    -> 
```
Impl:
````

````
Specs:
Server JVM
```

```
Server:
```

```
Results:
```

```
