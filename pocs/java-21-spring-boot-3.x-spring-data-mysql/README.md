### Build
```bash
./mvnw clean install
```
### Result
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-05-28T23:40:28.337-07:00  INFO 39289 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21.0.2 with PID 39289 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql)
2024-05-28T23:40:28.342-07:00  INFO 39289 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-05-28T23:40:29.389-07:00  INFO 39289 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2024-05-28T23:40:29.530-07:00  INFO 39289 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 136 ms. Found 1 JDBC repository interface.
New DataSource requested...
2024-05-28T23:40:30.019-07:00  INFO 39289 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-05-28T23:40:30.465-07:00  INFO 39289 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@2db6d68d
2024-05-28T23:40:30.467-07:00  INFO 39289 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
New TXManager requested...
2024-05-28T23:40:31.303-07:00  INFO 39289 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-05-28T23:40:31.690-07:00  INFO 39289 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-05-28T23:40:31.711-07:00  INFO 39289 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 3.868 seconds (process running for 4.374)
Spring Boot 3.3.0 up and running! 
Refreshing connections... TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 1
 Idle connections   : 9
 Total connections  : 10
HikariProxyConnection@1899390120 wrapping com.mysql.cj.jdbc.ConnectionImpl@24698cb4
HikariProxyConnection@231647545 wrapping com.mysql.cj.jdbc.ConnectionImpl@757ceef5
HikariProxyConnection@264486446 wrapping com.mysql.cj.jdbc.ConnectionImpl@67a79f4e
HikariProxyConnection@525891042 wrapping com.mysql.cj.jdbc.ConnectionImpl@d413bba
HikariProxyConnection@526501618 wrapping com.mysql.cj.jdbc.ConnectionImpl@446777bf
HikariProxyConnection@407694772 wrapping com.mysql.cj.jdbc.ConnectionImpl@1cd489ec
HikariProxyConnection@227777234 wrapping com.mysql.cj.jdbc.ConnectionImpl@7236de50
HikariProxyConnection@233352431 wrapping com.mysql.cj.jdbc.ConnectionImpl@354bdf57
HikariProxyConnection@606049830 wrapping com.mysql.cj.jdbc.ConnectionImpl@609f08ab
HikariProxyConnection@1132629176 wrapping com.mysql.cj.jdbc.ConnectionImpl@2db6d68d
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 10
 Idle connections   : 0
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 1
 Idle connections   : 9
 Total connections  : 10
Connection soft evicted!
Connection refreshed!
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 1
 Idle connections   : 0
 Total connections  : 1
HikariProxyConnection@31526393 wrapping com.mysql.cj.jdbc.ConnectionImpl@324a7875
HikariProxyConnection@472857421 wrapping com.mysql.cj.jdbc.ConnectionImpl@609e959c
HikariProxyConnection@1771684531 wrapping com.mysql.cj.jdbc.ConnectionImpl@8719625
HikariProxyConnection@1843474741 wrapping com.mysql.cj.jdbc.ConnectionImpl@79c77b60
HikariProxyConnection@1592566449 wrapping com.mysql.cj.jdbc.ConnectionImpl@5aa8c7f7
DB Loader done. 
HikariProxyConnection@1050950926 wrapping com.mysql.cj.jdbc.ConnectionImpl@7cfa5dc1
HikariProxyConnection@1203274181 wrapping com.mysql.cj.jdbc.ConnectionImpl@5b3371ba
HikariProxyConnection@1147169695 wrapping com.mysql.cj.jdbc.ConnectionImpl@6ada3287
HikariProxyConnection@1768890544 wrapping com.mysql.cj.jdbc.ConnectionImpl@29913286
HikariProxyConnection@1852479672 wrapping com.mysql.cj.jdbc.ConnectionImpl@559fc1f8
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 10
 Idle connections   : 0
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@7708b66a - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
```