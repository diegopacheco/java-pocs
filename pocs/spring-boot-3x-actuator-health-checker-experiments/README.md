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

<a href="https://htmlpreview.github.io/?https://github.com/diegopacheco/java-pocs/blob/master/pocs/server-benchmarks-fun/gatling-benchmarks/results/1k/nettymonosimulation-20230901072503134/index.html">full report</a>