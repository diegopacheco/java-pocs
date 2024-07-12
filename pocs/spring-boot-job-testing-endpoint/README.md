### Rationale

This is a way to test batch jobs but also have them @Scheduled with a cron to run.
The issue is you dont want wait the crom to kick in to test it. A endpoint that can call the job directely is great
so it allow integration tests and exploratory testing. However we dont want that endpoint in prod(because is a testing interface)
so there is some magic to disable the endpoint when running in prod.

Is possible to pass parameters to the batch job via the geenric rest controller `BatchController`. Some extra infra might still needed in order to mock or setup other dependencies but this by it self make it way more testable.

<center>
    <img src="overview.png" alt="overview" width="800"/>
</center>

### Build
```bash
./mvnw clean install
```
### Result
```
./run-non-prod.sh
```
```
❯ ./run-non-prod.sh

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.1)

2024-07-12T01:51:35.960-07:00  INFO 2699429 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 21 with PID 2699429 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-job-testing-endpoint/target/spring-boot-job-testing-endpoint-1.0-SNAPSHOT.war started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-job-testing-endpoint)
2024-07-12T01:51:35.963-07:00  INFO 2699429 --- [           main] c.g.d.sandboxspring.Application          : The following 1 profile is active: "dev"
2024-07-12T01:51:37.607-07:00  INFO 2699429 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-07-12T01:51:38.064-07:00  INFO 2699429 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-07-12T01:51:38.081-07:00  INFO 2699429 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.657 seconds (process running for 3.162)
Spring Boot 3.3.x working! 
2024-07-12T01:51:43.342-07:00  INFO 2699429 --- [or-http-epoll-2] c.g.d.s.batch.UUIDBatchService           : UUIDBatchService running. Generating UUIDs...
a8eeebf0-a469-4b0d-9d78-b9e7e36d977e
595312ca-c261-4651-a22d-581c5ae3efe3
5183e7e3-6de4-4d9b-a0d2-2d31e553d74b
6c494980-8afa-4b64-b90f-073ee84ff48d
29bec7ec-a85d-409f-a839-da7d8bc124ba
b95b8064-5c27-40bd-a677-159cadcb0e79
565c2795-7454-4536-9bbc-60e8b5ea76c0
afbbffde-2131-4db4-b1a6-ff199205ddf0
f07c965e-fbd5-4041-ad32-d7d8f7945db0
a7a47a14-fe54-4a6b-a6fd-bc8a766a0f00
```
goto
```
http://localhost:8080/batch/uuid
```
```
// 20240712014253
// http://localhost:8080/batch/uuid

true
```

try run prod...
```
./run-prod.sh
```
```
❯ ./run-prod.sh

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.1)

2024-07-12T01:52:43.835-07:00  INFO 2699838 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 21 with PID 2699838 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-job-testing-endpoint/target/spring-boot-job-testing-endpoint-1.0-SNAPSHOT.war started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-job-testing-endpoint)
2024-07-12T01:52:43.841-07:00  INFO 2699838 --- [           main] c.g.d.sandboxspring.Application          : The following 1 profile is active: "prod"
2024-07-12T01:52:45.661-07:00  INFO 2699838 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-07-12T01:52:46.195-07:00  INFO 2699838 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-07-12T01:52:46.210-07:00  INFO 2699838 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 2.926 seconds (process running for 3.433)
Spring Boot 3.3.x working! 
```
```
http://localhost:8080/batch/uuid
```
````
Whitelabel Error Page
This application has no configured error view, so you are seeing this as a fallback.

Fri Jul 12 01:53:18 PDT 2024
[6f64d203-1] There was an unexpected error (type=Not Found, status=404).
````