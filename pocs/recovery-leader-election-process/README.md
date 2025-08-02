### Build

```bash
./mvnw clean install
```

### Result

````bash
❯ ./start.sh
[+] Running 4/4
✔ Container recovery-leader-election-process-redis-1           Created                                                                                             0.0s
✔ Container recovery-leader-election-process-instance_app_1-1  Recreated                                                                                           0.1s
✔ Container recovery-leader-election-process-instance_app_2-1  Recreated                                                                                           0.1s
✔ Container recovery-leader-election-process-instance_app_3-1  Recreated                                                                                           0.1s
Attaching to instance_app_1-1, instance_app_2-1, instance_app_3-1, redis-1
redis-1           | 1:C 02 Aug 2025 08:14:31.588 # WARNING Memory overcommit must be enabled! Without it, a background save or replication may fail under low memory condition. Being disabled, it can also cause failures without low memory condition, see https://github.com/jemalloc/jemalloc/issues/1328. To fix this issue add 'vm.overcommit_memory = 1' to /etc/sysctl.conf and then reboot or run the command 'sysctl vm.overcommit_memory=1' for this to take effect.
redis-1           | 1:C 02 Aug 2025 08:14:31.588 * oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
redis-1           | 1:C 02 Aug 2025 08:14:31.588 * Redis version=7.2.10, bits=64, commit=00000000, modified=0, pid=1, just started
redis-1           | 1:C 02 Aug 2025 08:14:31.588 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf
redis-1           | 1:M 02 Aug 2025 08:14:31.588 * monotonic clock: POSIX clock_gettime
redis-1           | 1:M 02 Aug 2025 08:14:31.589 * Running mode=standalone, port=6379.
redis-1           | 1:M 02 Aug 2025 08:14:31.589 * Server initialized
redis-1           | 1:M 02 Aug 2025 08:14:31.592 * Loading RDB produced by version 7.2.10
redis-1           | 1:M 02 Aug 2025 08:14:31.592 * RDB age 148 seconds
redis-1           | 1:M 02 Aug 2025 08:14:31.592 * RDB memory usage when created 1.07 Mb
redis-1           | 1:M 02 Aug 2025 08:14:31.592 * Done loading RDB, keys loaded: 0, keys expired: 0.
redis-1           | 1:M 02 Aug 2025 08:14:31.592 * DB loaded from disk: 0.003 seconds
redis-1           | 1:M 02 Aug 2025 08:14:31.592 * Ready to accept connections tcp
instance_app_1-1  |
instance_app_1-1  |   .   ____          _            __ _ _
instance_app_1-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
instance_app_1-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
instance_app_1-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
instance_app_1-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
instance_app_1-1  |  =========|_|==============|___/=/_/_/_/
instance_app_1-1  | 
instance_app_1-1  |  :: Spring Boot ::                (v3.5.4)
instance_app_1-1  | 
instance_app_3-1  | 
instance_app_3-1  |   .   ____          _            __ _ _
instance_app_3-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
instance_app_3-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
instance_app_3-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
instance_app_3-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
instance_app_3-1  |  =========|_|==============|___/=/_/_/_/
instance_app_3-1  |
instance_app_3-1  |  :: Spring Boot ::                (v3.5.4)
instance_app_3-1  |
instance_app_2-1  |
instance_app_2-1  |   .   ____          _            __ _ _
instance_app_2-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
instance_app_2-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
instance_app_2-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
instance_app_2-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
instance_app_2-1  |  =========|_|==============|___/=/_/_/_/
instance_app_2-1  |
instance_app_2-1  |  :: Spring Boot ::                (v3.5.4)
instance_app_2-1  |
instance_app_1-1  | 2025-08-02T08:14:33.280Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 23.0.2 with PID 7 (/app/app.war started by root in /app)
instance_app_1-1  | 2025-08-02T08:14:33.284Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
instance_app_3-1  | 2025-08-02T08:14:33.378Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 23.0.2 with PID 7 (/app/app.war started by root in /app)
instance_app_3-1  | 2025-08-02T08:14:33.384Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
instance_app_2-1  | 2025-08-02T08:14:33.412Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 23.0.2 with PID 7 (/app/app.war started by root in /app)
instance_app_2-1  | 2025-08-02T08:14:33.419Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
instance_app_1-1  | >> Starting Leader Election from this Slot: 232db941-8a79-4cdb-a873-5adaf0dce9c8 port: 8081
instance_app_1-1  | >> Register my slot in redis DONE
instance_app_1-1  | >>> Generating 10 ids for db
instance_app_2-1  | >> Starting Leader Election from this Slot: baf4afb0-59f2-4d62-b1de-37dade77bb52 port: 8082
instance_app_2-1  | >> Register my slot in redis DONE
instance_app_2-1  | >>> Generating 10 ids for db
instance_app_1-1  | Generated: 10 ids for work.
instance_app_1-1  | Lock acquired by slot: 232db941-8a79-4cdb-a873-5adaf0dce9c8 I'm the leader
instance_app_1-1  | >> Starting split work...
instance_app_2-1  | Generated: 10 ids for work.
instance_app_2-1  | Lock NOT acquired. Another slot is leader.
instance_app_2-1  | >> Waiting for leader to finish work...
instance_app_3-1  | >> Starting Leader Election from this Slot: aa5f77c5-108e-4d83-a800-c5d148368a5a port: 8083
instance_app_1-1  | >> Work split DONE
instance_app_1-1  | >> Releasing lock...
instance_app_1-1  | >> Lock released
instance_app_3-1  | >> Register my slot in redis DONE
instance_app_3-1  | >>> Generating 10 ids for db
instance_app_3-1  | Generated: 10 ids for work.
instance_app_3-1  | Lock acquired by slot: aa5f77c5-108e-4d83-a800-c5d148368a5a I'm the leader
instance_app_3-1  | >> Starting split work...
instance_app_3-1  | >> Work split DONE
instance_app_3-1  | >> Releasing lock...
instance_app_3-1  | >> Lock released
instance_app_1-1  | 2025-08-02T08:14:37.045Z  INFO 7 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
instance_app_3-1  | 2025-08-02T08:14:37.355Z  INFO 7 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
instance_app_1-1  | 2025-08-02T08:14:37.810Z  INFO 7 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8081 (http)
instance_app_1-1  | 2025-08-02T08:14:37.840Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 5.278 seconds (process running for 6.047)
instance_app_1-1  | Spring Boot 3.5.x working!
instance_app_3-1  | 2025-08-02T08:14:37.946Z  INFO 7 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8083 (http)
instance_app_3-1  | 2025-08-02T08:14:37.972Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 5.347 seconds (process running for 6.146)
instance_app_3-1  | Spring Boot 3.5.x working!
instance_app_2-1  | >> Getting my IDs from slot: baf4afb0-59f2-4d62-b1de-37dade77bb52
instance_app_2-1  | >> My IDs: 848ee1a8-90a2-4069-bf3e-2c1ccbaf488f,ca2f8b6c-55ef-4a38-b95b-156642a3a5e3,13b92867-1003-4615-8acd-437c0fe3af6b,426e6be5-77d1-4687-a057-2b470228e712,848ee1a8-90a2-4069-bf3e-2c1ccbaf488f,fb181f8d-03ba-4ae2-bfdb-a94860975443,ed14b81a-2899-4e52-8291-ff602ae9b755,da5197ec-7ad3-47da-8992-f821b69b11c8,3b829a5d-4e72-4a20-9a4e-c8dfb8d63877,8bc23de7-8a00-423a-bba4-028286a04615
instance_app_2-1  | 2025-08-02T08:14:51.725Z  INFO 7 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
instance_app_2-1  | 2025-08-02T08:14:51.998Z  INFO 7 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8082 (http)
instance_app_2-1  | 2025-08-02T08:14:52.014Z  INFO 7 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 19.363 seconds (process running for 20.191)
instance_app_2-1  | Spring Boot 3.5.x working!
```