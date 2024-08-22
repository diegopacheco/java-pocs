### Build
```bash
./mvnw clean install
```

### Findings

1. Spring Boot does `not cache` health check responses by default.
2. @Cacheable The cache in the provided code lives as long as the application is running because it uses an in-memory cache (ConcurrentMapCacheManager).
* application.properties: needs this:
```
management.endpoints.web.exposure.include=health
management.endpoint.health.show-details=always
```
otherwise additional health checkers are not called and details dont show up.
3. It's possible to change actuator default url `/actuator/health` by adding this 2 properties on application.properties
```
management.endpoints.web.base-path=/
#management.endpoints.web.path-mapping.health=health_checker
```
Resulting in `http://localhost:8080/health_checker`
4. Spring Boot autodetects he is running on k8s and the health checker does more things to get the readiness and liveness states.
5. Spring Boot Actuator classes:
  * ReadinessStateHealthIndicator
  * LivenessStateHealthIndicator
  * HealthIndicatorReactiveAdapter
  * BoundedElasticSchedulerSupplier (size 120, queuedTaskCap 100k, TTL 60s, daemon true)
  * ReactiveHealthEndpointWebExtension (Line#81)
  * ApplicationAvailabilityBean
6. Stress Test with gatling against kubernetes shows Health checker holds 500 concurrent calls with no issues - very fast response time < ~800ms.

### When running in k8s - different behavior - how to reproduce

1. step 1: build the app
```
./mvnw clean install
```
2. step 2: build the docker image
```
./build-container.sh
```
3. step 3: run the docker image (test)
```
./run-container.sh
```
```
./test.sh
```
```
❯ ./docker-run.sh

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-21T04:24:24.254Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 21 with PID 1 (/app/app.war started by root in /app)
2024-08-21T04:24:24.258Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-08-21T04:24:26.187Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-08-21T04:24:26.722Z  INFO 1 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-08-21T04:24:26.742Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 3.034 seconds (process running for 3.577)
Spring Boot 3.3.x working! 
[HC3] Health checker custom UP and called... 
[HC3] Health checker custom UP and called... 
```
4. step 4: stop the docker image
5. step 5: create k8s kind cluster
```
./k8s-kind-create-cluster.sh
```
```
❯ ./k8s-kind-create-cluster.sh
Creating cluster "kind" ...
 ✓ Ensuring node image (kindest/node:v1.30.0) 🖼
 ✓ Preparing nodes 📦 📦 📦  
 ✓ Writing configuration 📜 
 ✓ Starting control-plane 🕹️ 
 ✓ Installing CNI 🔌 
 ✓ Installing StorageClass 💾 
 ✓ Joining worker nodes 🚜 
Set kubectl context to "kind-kind"
You can now use your cluster with:

kubectl cluster-info --context kind-kind

Not sure what to do next? 😅  Check out https://kind.sigs.k8s.io/docs/user/quick-start/
```
6. Step 6: deploy the app to k8s
```
./k8s-kind-deploy-app.sh
```
7. Step 7: forward the port to the app
```
./k8s-kind-forward-port-app.sh
```
```
❯ ./k8s-kind-forward-port-app.sh
Forwarding from 127.0.0.1:8080 -> 8080
Handling connection for 8080
Handling connection for 8080
Handling connection for 8080
Handling connection for 8080
Handling connection for 8080

```

8. Step 8: test the app
```
./test.sh
```
```
❯ ./test.sh
HTTP/1.1 200 OK
Content-Type: application/vnd.spring-boot.actuator.v3+json
Content-Length: 446

{"status":"UP","components":{"customHealthCheckIndicator":{"status":"UP","details":{"luckyNumber":42,"bestTeam":"Gremio","EXECUTION_ID":"4f3e6c89-dc4a-4c0d-97c0-5d8280370144","nonProd":true}},"diskSpace":{"status":"UP","details":{"total":490577010688,"free":99412680704,"threshold":10485760,"path":"/app/.","exists":true}},"livenessState":{"status":"UP"},"ping":{"status":"UP"},"readinessState":{"status":"UP"}},"groups":["liveness","readiness"]}
HC return in [0.01 seconds]
{
  "status": "UP",
  "components": {
    "customHealthCheckIndicator": {
      "status": "UP",
      "details": {
        "luckyNumber": 42,
        "bestTeam": "Gremio",
        "EXECUTION_ID": "12d1a752-a59a-42bb-8099-e549fe128155",
        "nonProd": true
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 490577010688,
        "free": 99412684800,
        "threshold": 10485760,
        "path": "/app/.",
        "exists": true
      }
    },
    "livenessState": {
      "status": "UP"
    },
    "ping": {
      "status": "UP"
    },
    "readinessState": {
      "status": "UP"
    }
  },
  "groups": [
    "liveness",
    "readiness"
  ]
}
```

Spring Actuator has 2 different health checkers for liveness and readiness probes
```
❯ curl -s http://localhost:8080/actuator/health/readiness | jq .
{
  "status": "UP"
}
❯ curl -s http://localhost:8080/actuator/health/liveness | jq .
{
  "status": "UP"
}
```

### Stress Test

1. Step 1: run the stress test
```
./run-gatling.sh
```
```

================================================================================
---- Global Information --------------------------------------------------------
> request count                                      30000 (OK=30000  KO=0     )
> min response time                                      1 (OK=1      KO=-     )
> max response time                                    444 (OK=444    KO=-     )
> mean response time                                    39 (OK=39     KO=-     )
> std deviation                                         56 (OK=56     KO=-     )
> response time 50th percentile                          5 (OK=5      KO=-     )
> response time 75th percentile                         61 (OK=61     KO=-     )
> response time 95th percentile                        141 (OK=141    KO=-     )
> response time 99th percentile                        273 (OK=273    KO=-     )
> mean requests/sec                                491.803 (OK=491.803 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                         30000 (100%)
> 800 ms <= t < 1200 ms                                  0 (  0%)
> t >= 1200 ms                                           0 (  0%)
> failed                                                 0 (  0%)
================================================================================
```

<a href="https://htmlpreview.github.io/?https://raw.githubusercontent.com/diegopacheco/java-pocs/master/pocs/spring-boot-3x-actuator-health-checker-experiments/stress-test-results/actuatorhealthcheckersimulation-20240821055519082/index.html">full report</a>

### K8s resource contention test

#### Scenario A: low resources - 1x call

config
```
resources:
limits:
  memory: "512Mi"
  cpu: "500m"
requests:
  memory: "256Mi"
  cpu: "250m"
```

k8s port forward
```
❯ ./k8s-kind-forward-port-app.sh
Forwarding from 127.0.0.1:8080 -> 8080
Forwarding from [::1]:8080 -> 8080
Handling connection for 8080
Handling connection for 8080
Handling connection for 8080
```

test 1 request takes 1s to return
```
❯ ./test-slow-1s.sh
{
  "result": "f23b4306-eadc-413e-8245-618756519c70",
  "time": "1000 ms"
}
```

#### Scenario B: even less - low resources - 1x call - crash kind port forwarder 

config
```
resources:
limits:
  memory: "512Mi"
  cpu: "100m"
requests:
  memory: "256Mi"
  cpu: "100m"
```

k8s port forward
```
❯ ./k8s-kind-forward-port-app.sh
Forwarding from 127.0.0.1:8080 -> 8080
Forwarding from [::1]:8080 -> 8080
Handling connection for 8080
E0821 20:35:17.963758 3296100 portforward.go:407] an error occurred forwarding 8080 -> 8080: error forwarding port 8080 to pod 8cb72a6aaf70936ef03dd5362da413c824996dfbb4f815f0033af2effa831d89, uid : failed to execute portforward in network namespace "/var/run/netns/cni-fe23b87d-bfc2-d65e-8c2a-ddc46cda090f": failed to connect to localhost:8080 inside namespace "8cb72a6aaf70936ef03dd5362da413c824996dfbb4f815f0033af2effa831d89", IPv4: dial tcp4 127.0.0.1:8080: connect: connection refused IPv6 dial tcp6 [::1]:8080: connect: connection refused 
E0821 20:35:17.964056 3296100 portforward.go:233] lost connection to pod
```

test 1 request takes 1s to return (NO RESPONSE)
```
❯ ./test-slow-1s.sh
```

#### Scenario C: more resources - 500c/sec gatling

config
```
resources:
limits:
  memory: "1024Mi"
  cpu: "1000m"
requests:
  memory: "1024Mi"
  cpu: "1000m"
```

k8s port forward
```
❯ ./k8s-kind-forward-port-app.sh
Forwarding from 127.0.0.1:8080 -> 8080
Forwarding from [::1]:8080 -> 8080
Handling connection for 8080
```

gatling stress test - 500c/sec
```
❯ ./run-gatling.sh
```
```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      30000 (OK=19114  KO=10886 )
> min response time                                    565 (OK=565    KO=35149 )
> max response time                                  59272 (OK=34057  KO=59272 )
> mean response time                                 28609 (OK=18545  KO=46282 )
> std deviation                                      14537 (OK=5313   KO=6529  )
> response time 50th percentile                      20359 (OK=17146  KO=46161 )
> response time 75th percentile                      42004 (OK=19247  KO=51639 )
> response time 95th percentile                      54431 (OK=30913  KO=56890 )
> response time 99th percentile                      57421 (OK=32880  KO=57936 )
> mean requests/sec                                309.278 (OK=197.052 KO=112.227)
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                            11 (  0%)
> 800 ms <= t < 1200 ms                                 13 (  0%)
> t >= 1200 ms                                       19090 ( 64%)
> failed                                             10886 ( 36%)
---- Errors --------------------------------------------------------------------
> j.i.IOException: Premature close                                10886 (100.0%)
================================================================================
```

k8s port forward
```
Handling connection for 8080
Handling connection for 8080
E0821 20:42:22.393334 3297977 portforward.go:233] lost connection to pod
```

#### Scenario D: even more resources - 500c/sec gatling

config
```
resources:
limits:
  memory: "4096Mi"
  cpu: "4095m"
requests:
  memory: "4096Mi"
  cpu: "4095m"
```

k8s port forward
```
Handling connection for 8080
Handling connection for 8080
```

gatling stress test - 500c/sec
```
❯ ./run-gatling.sh
```
```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      30000 (OK=30000  KO=0     )
> min response time                                      2 (OK=2      KO=-     )
> max response time                                   1371 (OK=1371   KO=-     )
> mean response time                                   110 (OK=110    KO=-     )
> std deviation                                        300 (OK=300    KO=-     )
> response time 50th percentile                          4 (OK=4      KO=-     )
> response time 75th percentile                         11 (OK=11     KO=-     )
> response time 95th percentile                       1003 (OK=1004   KO=-     )
> response time 99th percentile                       1229 (OK=1229   KO=-     )
> mean requests/sec                                491.803 (OK=491.803 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                         27606 ( 92%)
> 800 ms <= t < 1200 ms                               1962 (  7%)
> t >= 1200 ms                                         432 (  1%)
> failed                                                 0 (  0%)
================================================================================
```

#### Scenario E: Same as D but with reactive endpoint (no threads*) 

config
```
resources:
limits:
  memory: "4096Mi"
  cpu: "4095m"
requests:
  memory: "4096Mi"
  cpu: "4095m"
```

k8s port forward
```
Handling connection for 8080
Handling connection for 8080
```

gatling stress test - 500c/sec
```
❯ ./run-gatling.sh
```
```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      30000 (OK=30000  KO=0     )
> min response time                                      1 (OK=1      KO=-     )
> max response time                                   2171 (OK=2171   KO=-     )
> mean response time                                   506 (OK=506    KO=-     )
> std deviation                                        633 (OK=633    KO=-     )
> response time 50th percentile                         60 (OK=60     KO=-     )
> response time 75th percentile                       1149 (OK=1149   KO=-     )
> response time 95th percentile                       1660 (OK=1660   KO=-     )
> response time 99th percentile                       1989 (OK=1989   KO=-     )
> mean requests/sec                                491.803 (OK=491.803 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                         20302 ( 68%)
> 800 ms <= t < 1200 ms                               3064 ( 10%)
> t >= 1200 ms                                        6634 ( 22%)
> failed                                                 0 (  0%)
================================================================================
```

stop and start the containers again just run again...
```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      30000 (OK=30000  KO=0     )
> min response time                                      1 (OK=1      KO=-     )
> max response time                                    789 (OK=789    KO=-     )
> mean response time                                   125 (OK=125    KO=-     )
> std deviation                                        160 (OK=160    KO=-     )
> response time 50th percentile                         63 (OK=63     KO=-     )
> response time 75th percentile                        169 (OK=169    KO=-     )
> response time 95th percentile                        500 (OK=500    KO=-     )
> response time 99th percentile                        671 (OK=671    KO=-     )
> mean requests/sec                                491.803 (OK=491.803 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                         30000 (100%)
> 800 ms <= t < 1200 ms                                  0 (  0%)
> t >= 1200 ms                                           0 (  0%)
> failed                                                 0 (  0%)
================================================================================
```
I expected this to be better. Because `CustomHealthCheckIndicatorReactive` explicitly does `Mono.just`
which does not create threads and return immediately also 
avoid spring doing `HealthIndicatorReactiveAdapter` when non-reactive endpoint is running... 
the code is this: 
```
@Override
public Mono<Health> health() {
    return Mono.fromCallable(this.delegate::health).subscribeOn(Schedulers.boundedElastic());
}
```
```
Schedulers.boundedElastic()
```
* thread pool size 120
* queuedTaskCap 100k
* TTL 60s
* daemon true
COULD create contention in high volumes.

but if I run gatling one more time... 
```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      30000 (OK=30000  KO=0     )
> min response time                                      2 (OK=2      KO=-     )
> max response time                                  17355 (OK=17355  KO=-     )
> mean response time                                  3443 (OK=3443   KO=-     )
> std deviation                                       4067 (OK=4067   KO=-     )
> response time 50th percentile                       2456 (OK=2456   KO=-     )
> response time 75th percentile                       3277 (OK=3277   KO=-     )
> response time 95th percentile                      12720 (OK=12720  KO=-     )
> response time 99th percentile                      13106 (OK=13106  KO=-     )
> mean requests/sec                                405.405 (OK=405.405 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                          9273 ( 31%)
> 800 ms <= t < 1200 ms                                284 (  1%)
> t >= 1200 ms                                       20443 ( 68%)
> failed                                                 0 (  0%)
================================================================================
```
Results are degraded, so looks like some contention is happening.

### Debugging Webflux

classes
 * InvocableHandlerMethod
```
L#198 -> value = method.invoke(getBean(), args);
 * Calls target spring bean - controller in case
L#232 -> HandlerResult result = new HandlerResult(this, value, returnType, bindingContext);
 * Wraps the result into a mono with mono.just 
```
 * MonoZip
 * MonoIgnoreThen
 * HandlerResult
 * MonoPeekTerminal
 * Operators
 * reactor.netty.http.server.HttpServer
 * HttpServer.HttpServerHandle.onStateChange
 * ReactorNetty
```
    public static final String IO_WORKER_COUNT = "reactor.netty.ioWorkerCount";
    public static final String IO_SELECT_COUNT = "reactor.netty.ioSelectCount";
    public static final String UDP_IO_THREAD_COUNT = "reactor.netty.udp.ioThreadCount";
    public static final String SHUTDOWN_QUIET_PERIOD = "reactor.netty.ioShutdownQuietPeriod";
    public static final String SHUTDOWN_TIMEOUT = "reactor.netty.ioShutdownTimeout";
    public static final String NATIVE = "reactor.netty.native";
    public static final String POOL_MAX_CONNECTIONS = "reactor.netty.pool.maxConnections";
    public static final String POOL_ACQUIRE_TIMEOUT = "reactor.netty.pool.acquireTimeout";
    public static final String POOL_MAX_IDLE_TIME = "reactor.netty.pool.maxIdleTime";
    public static final String POOL_MAX_LIFE_TIME = "reactor.netty.pool.maxLifeTime";
```
* ReactorNetty.CompositeConnectionObserver.onStateChange
* io.netty.channel.AbstractChannelHandlerContext
* reactor.netty.http.server.HttpTrafficHandler

### Reactor Netty Metrics

* http://localhost:8080/actuator/metrics/reactor.netty.ioWorkerCount - 4 
* http://localhost:8080/actuator/metrics/reactor.netty.pool.maxConnections - 16
* http://localhost:8080/actuator/metrics/reactor.netty.udp.ioThreadCount - 4


http://localhost:8080/actuator/metrics/reactor.netty.eventloop.pending.tasks
had to run gatling to see >0 so some traffic needed.
```
// 20240821234816
// http://localhost:8080/actuator/metrics/reactor.netty.eventloop.pending.tasks

{
  "name": "reactor.netty.eventloop.pending.tasks",
  "measurements": [
    {
      "statistic": "VALUE",
      "value": 12.0
    }
  ],
  "availableTags": [
    {
      "tag": "name",
      "values": [
        "reactor-http-io_uring-12",
        "reactor-http-io_uring-9",
        "reactor-http-io_uring-8",
        "reactor-http-io_uring-7",
        "reactor-http-io_uring-6",
        "reactor-http-io_uring-5",
        "reactor-http-io_uring-11",
        "reactor-http-io_uring-4",
        "reactor-http-io_uring-10",
        "reactor-http-io_uring-3",
        "reactor-http-io_uring-2",
        "reactor-http-io_uring-1"
      ]
    }
  ]
}
```

Good links
* https://projectreactor.io/docs/netty/snapshot/api/index.html?reactor/netty/Metrics.html

* http://localhost:8080/actuator/metrics/executor.pool.size
while running gatling...
```
{
  "name": "executor.pool.size",
  "description": "The current number of threads in the pool",
  "baseUnit": "threads",
  "measurements": [
    {
      "statistic": "VALUE",
      "value": 20
    }
  ],
  "availableTags": [
    {
      "tag": "reactor.scheduler.id",
      "values": [
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)"
      ]
    },
    {
      "tag": "name",
      "values": [
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-8",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-9",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-19",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-0",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-15",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-1",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-16",
        "applicationTaskExecutor",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-2",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-17",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-3",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-18",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-4",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-11",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-5",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-12",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-6",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-13",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-7",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-14",
        "boundedElastic(\"boundedElastic\",maxThreads=120,maxTaskQueuedPerThread=100000,ttl=60s)-10"
      ]
    }
  ]
```