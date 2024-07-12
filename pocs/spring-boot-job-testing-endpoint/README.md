### Build
```bash
./mvnw clean install
```
### Result
goto
```
http://localhost:8080/batch/uuid
```
```
// 20240712014253
// http://localhost:8080/batch/uuid

true
```
Result is:
```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.1)

2024-07-12T01:42:37.682-07:00  INFO 2696847 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21 with PID 2696847 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-job-testing-endpoint/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-job-testing-endpoint)
2024-07-12T01:42:37.685-07:00  INFO 2696847 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-07-12T01:42:39.222-07:00  INFO 2696847 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-07-12T01:42:39.675-07:00  INFO 2696847 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-07-12T01:42:39.689-07:00  INFO 2696847 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.351 seconds (process running for 2.689)
Spring Boot 3.3.x working! 
2024-07-12T01:42:53.482-07:00  INFO 2696847 --- [or-http-epoll-2] c.g.d.s.batch.UUIDBatchService           : UUIDBatchService running. Generating UUIDs...
62a23fa0-6307-4cfc-96ed-a8ccb248bf43
9be328c9-5b26-4e84-b315-e4b4f0704e30
ea7ac124-ee4c-4203-8d36-875493ccb380
83f03bd6-a564-4369-957f-b95da4283daf
087d0681-dece-4ce8-a306-4db1b16c4b50
df9ddd1e-482a-4060-85c9-ea7eb6741a55
adeb7797-55e4-4e15-ab18-66324e890442
f91f99b4-3a4b-4af0-8b82-8c76fd5c4e3a
3fe84b11-33bc-4c5f-a730-b2ac4e2f9d27
39667038-8314-4e5b-86d4-5dfc123d8e78
```