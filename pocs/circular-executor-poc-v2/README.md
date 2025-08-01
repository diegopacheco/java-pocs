## Rationale

Imagine you must call some 3rd party dependency(downstream dependency) that sucks, it's easily super slow or cranky, or fail at unexpected times or even all options above maybe takes 1h, 10h, 1 day or 3 days to return success. You do not want go on the timeout path because it's dangerous, you might need to tweak forever and might lead to a deny of service (DOS) problem. So we need some different approach, which here will be a circular queue where tasks can a chance to run but if they dont achieve the expected you re-try time to time so the queue it self works are a backpressure mechanism.

## V1

https://github.com/diegopacheco/java-pocs/tree/master/pocs/circular-executor-poc

## V2

Here we have some differences form v1 design:
* It's single threaded, so no need to worry about resource exhaustion.
* We still have a circular queue but much better double from the `task`(busiess work) and the task of tracking attemps `managerTask`
* Need to be careful, if do reflection on the service CircularExecutionService because it will always create a Thread. This could be improved by explicit declaring the Executor in spring and them injecting the executor here.
* WorkerTracker is a more explicit tracking object and is immutable. There is a static Factory pattern there(`from`).

### Build

```bash
./mvnw clean install
```

### Results

```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.4)

2025-07-31T23:22:11.079-07:00  INFO 3913857 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 23.0.2 with PID 3913857 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/circular-executor-poc-v2/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/circular-executor-poc-v2)
2025-07-31T23:22:11.082-07:00  INFO 3913857 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2025-07-31T23:22:12.847-07:00  INFO 3913857 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-07-31T23:22:13.361-07:00  INFO 3913857 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2025-07-31T23:22:13.380-07:00  INFO 3913857 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.818 seconds (process running for 3.28)
Spring Boot 3.5.x working! 
>>> Running Expensive Computation. Attempt: [0]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [1]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [2]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [3]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [4]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [5]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [6]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [7]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [8]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [9]
>>> Failure! Lets Retry
>>> Running Expensive Computation. Attempt: [10]
>>> Success!
```