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

2024-05-28T23:46:19.631-07:00  INFO 40573 --- [           main] c.g.d.sandboxspring.Application          : Starting Application using Java 21.0.2 with PID 40573 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-21-spring-boot-3.x-spring-data-mysql)
2024-05-28T23:46:19.635-07:00  INFO 40573 --- [           main] c.g.d.sandboxspring.Application          : No active profile set, falling back to 1 default profile: "default"
2024-05-28T23:46:20.607-07:00  INFO 40573 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2024-05-28T23:46:20.762-07:00  INFO 40573 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 150 ms. Found 1 JDBC repository interface.
New DataSource requested...
2024-05-28T23:46:21.327-07:00  INFO 40573 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-05-28T23:46:21.773-07:00  INFO 40573 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@2d5a1588
2024-05-28T23:46:21.774-07:00  INFO 40573 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
New TXManager requested...
2024-05-28T23:46:22.732-07:00  INFO 40573 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-05-28T23:46:23.128-07:00  INFO 40573 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-05-28T23:46:23.157-07:00  INFO 40573 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 4.091 seconds (process running for 4.566)
Spring Boot 3.3.0 up and running! 
Refreshing connections... TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 1
 Idle connections   : 9
 Total connections  : 10
HikariProxyConnection@323079571 wrapping com.mysql.cj.jdbc.ConnectionImpl@6e08935e
HikariProxyConnection@1329895588 wrapping com.mysql.cj.jdbc.ConnectionImpl@73b864e6
HikariProxyConnection@1423939640 wrapping com.mysql.cj.jdbc.ConnectionImpl@7ee7739e
HikariProxyConnection@353191262 wrapping com.mysql.cj.jdbc.ConnectionImpl@25228c4d
HikariProxyConnection@219471497 wrapping com.mysql.cj.jdbc.ConnectionImpl@482a3736
HikariProxyConnection@930266328 wrapping com.mysql.cj.jdbc.ConnectionImpl@6830e9f
HikariProxyConnection@759724112 wrapping com.mysql.cj.jdbc.ConnectionImpl@34426948
HikariProxyConnection@385128292 wrapping com.mysql.cj.jdbc.ConnectionImpl@81d84d3
HikariProxyConnection@1727653752 wrapping com.mysql.cj.jdbc.ConnectionImpl@4156dac6
HikariProxyConnection@393479061 wrapping com.mysql.cj.jdbc.ConnectionImpl@2d5a1588
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 10
 Idle connections   : 0
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
Connection soft evicted!
Connection refreshed!
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 0
 Total connections  : 0
HikariProxyConnection@353933102 wrapping com.mysql.cj.jdbc.ConnectionImpl@18337207
HikariProxyConnection@979986794 wrapping com.mysql.cj.jdbc.ConnectionImpl@515fc492
HikariProxyConnection@11503728 wrapping com.mysql.cj.jdbc.ConnectionImpl@38f6128
DB Loader done. 
HikariProxyConnection@1927047690 wrapping com.mysql.cj.jdbc.ConnectionImpl@5d085b97
HikariProxyConnection@563655758 wrapping com.mysql.cj.jdbc.ConnectionImpl@59e61774
HikariProxyConnection@1216068216 wrapping com.mysql.cj.jdbc.ConnectionImpl@57b09403
HikariProxyConnection@862875775 wrapping com.mysql.cj.jdbc.ConnectionImpl@5ada9cd1
HikariProxyConnection@1332172168 wrapping com.mysql.cj.jdbc.ConnectionImpl@1c24d0eb
HikariProxyConnection@1552524952 wrapping com.mysql.cj.jdbc.ConnectionImpl@52bb95cc
HikariProxyConnection@663048454 wrapping com.mysql.cj.jdbc.ConnectionImpl@1d9c7e95
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 10
 Idle connections   : 0
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
HikariProxyConnection@212907736 wrapping com.mysql.cj.jdbc.ConnectionImpl@1d9c7e95
HikariProxyConnection@44783479 wrapping com.mysql.cj.jdbc.ConnectionImpl@52bb95cc
HikariProxyConnection@262880069 wrapping com.mysql.cj.jdbc.ConnectionImpl@1c24d0eb
HikariProxyConnection@1908245747 wrapping com.mysql.cj.jdbc.ConnectionImpl@5ada9cd1
HikariProxyConnection@2016606826 wrapping com.mysql.cj.jdbc.ConnectionImpl@57b09403
HikariProxyConnection@544873204 wrapping com.mysql.cj.jdbc.ConnectionImpl@59e61774
HikariProxyConnection@1985834157 wrapping com.mysql.cj.jdbc.ConnectionImpl@5d085b97
HikariProxyConnection@1801122953 wrapping com.mysql.cj.jdbc.ConnectionImpl@38f6128
HikariProxyConnection@81048098 wrapping com.mysql.cj.jdbc.ConnectionImpl@515fc492
HikariProxyConnection@1946789366 wrapping com.mysql.cj.jdbc.ConnectionImpl@18337207
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 10
 Idle connections   : 0
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
*** TX manager: org.springframework.jdbc.datasource.DataSourceTransactionManager@333398f - DS: HikariDataSource (HikariPool-1)
 Active connections : 0
 Idle connections   : 10
 Total connections  : 10
2024-05-28T23:46:31.575-07:00  INFO 40573 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2024-05-28T23:46:31.581-07:00  INFO 40573 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

### Rationale

How do I know this refresh is working? A lot of things could go wrong. 
Luckily Hicari is smart enough to know to drain connections it does 2 things:
1. It drains connections immediately if they are idle
2. Delay draining connections that are in use.

Consider the code:
```
1.    @Scheduled(fixedRate = 5000)
2.    public void refresh() throws Exception {
3.        if (!done) {
4.            System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);
5.            traceConnections();
6.
7.            ds.getHikariPoolMXBean().softEvictConnections();
8.            done = true;
9.            System.out.println("Connection soft evicted!");
10.
11.           txManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
12.           ds = (HikariDataSource) ctx.getBean("dataSource");
13.           System.out.println("Connection refreshed!");
14.           traceConnections();
15.           traceConnections();
16.       }
17.       traceDS();
18.  }
```

Line #5 traceConnections() result is this: (list 1)
```
HikariProxyConnection@323079571 wrapping com.mysql.cj.jdbc.ConnectionImpl@6e08935e
HikariProxyConnection@1329895588 wrapping com.mysql.cj.jdbc.ConnectionImpl@73b864e6
HikariProxyConnection@1423939640 wrapping com.mysql.cj.jdbc.ConnectionImpl@7ee7739e
HikariProxyConnection@353191262 wrapping com.mysql.cj.jdbc.ConnectionImpl@25228c4d
HikariProxyConnection@219471497 wrapping com.mysql.cj.jdbc.ConnectionImpl@482a3736
HikariProxyConnection@930266328 wrapping com.mysql.cj.jdbc.ConnectionImpl@6830e9f
HikariProxyConnection@759724112 wrapping com.mysql.cj.jdbc.ConnectionImpl@34426948
HikariProxyConnection@385128292 wrapping com.mysql.cj.jdbc.ConnectionImpl@81d84d3
HikariProxyConnection@1727653752 wrapping com.mysql.cj.jdbc.ConnectionImpl@4156dac6
HikariProxyConnection@393479061 wrapping com.mysql.cj.jdbc.ConnectionImpl@2d5a1588
```
Why I'm doing this? Well before doing the soft eviction I want see the Id of the JDBC connection objects.
```
ConnectionImpl@6e08935e
```
I dont want see this repeting on the next logs, because if they repeat something wrong happens.
Either the eviction did not happen or some other problem.
Now line #7 does the magic
```
ds.getHikariPoolMXBean().softEvictConnections();
```
Line #14 and #15 matters a lot
```
traceConnections()
traceConnections()
```
because now I want see IDS being reused for the connection but must be different from first list.(list 1).
This is (list 2)
```
HikariProxyConnection@353933102 wrapping com.mysql.cj.jdbc.ConnectionImpl@18337207
HikariProxyConnection@979986794 wrapping com.mysql.cj.jdbc.ConnectionImpl@515fc492
HikariProxyConnection@11503728 wrapping com.mysql.cj.jdbc.ConnectionImpl@38f6128
HikariProxyConnection@1927047690 wrapping com.mysql.cj.jdbc.ConnectionImpl@5d085b97
HikariProxyConnection@563655758 wrapping com.mysql.cj.jdbc.ConnectionImpl@59e61774
HikariProxyConnection@1216068216 wrapping com.mysql.cj.jdbc.ConnectionImpl@57b09403
HikariProxyConnection@862875775 wrapping com.mysql.cj.jdbc.ConnectionImpl@5ada9cd1
HikariProxyConnection@1332172168 wrapping com.mysql.cj.jdbc.ConnectionImpl@1c24d0eb
HikariProxyConnection@1552524952 wrapping com.mysql.cj.jdbc.ConnectionImpl@52bb95cc
HikariProxyConnection@663048454 wrapping com.mysql.cj.jdbc.ConnectionImpl@1d9c7e95
```
and followed by (list 3)
```
HikariProxyConnection@212907736 wrapping com.mysql.cj.jdbc.ConnectionImpl@1d9c7e95
HikariProxyConnection@44783479 wrapping com.mysql.cj.jdbc.ConnectionImpl@52bb95cc
HikariProxyConnection@262880069 wrapping com.mysql.cj.jdbc.ConnectionImpl@1c24d0eb
HikariProxyConnection@1908245747 wrapping com.mysql.cj.jdbc.ConnectionImpl@5ada9cd1
HikariProxyConnection@2016606826 wrapping com.mysql.cj.jdbc.ConnectionImpl@57b09403
HikariProxyConnection@544873204 wrapping com.mysql.cj.jdbc.ConnectionImpl@59e61774
HikariProxyConnection@1985834157 wrapping com.mysql.cj.jdbc.ConnectionImpl@5d085b97
HikariProxyConnection@1801122953 wrapping com.mysql.cj.jdbc.ConnectionImpl@38f6128
HikariProxyConnection@81048098 wrapping com.mysql.cj.jdbc.ConnectionImpl@515fc492
HikariProxyConnection@1946789366 wrapping com.mysql.cj.jdbc.ConnectionImpl@18337207
```
list 2 and list 3 overlap - meaning the connection pooling is working and reuse connections as
it should reuse them. But they are never the same as (list 1) so it's good.

### How to test it with automated code?

Option A

0. Should be a for loop for 10(total number of connection onf the pool)
1. Capture the toString in `ds.getConnection()` and parse the last part `com.mysql.cj.jdbc.ConnectionImpl@1d9c7e95`
extract the value after the `@`, Store it - first list must be unique.
2. Second and thrird capture sohuld have the same ids, the order does not matter.

Option B

0. Should be a for loop for 10(total number of connection onf the pool)
1. Wrap the JDBC driver just for testing
2. Create a custom interceptor by extending the class and capture the IDs of the underlying JDBC connection. first list must be unique.
2. Second and third capture should have the same ids, the order does not matter.

Option C

0. Same assumptions as the other options but - here we will use reflection
1. This is how we can get the IDS `((HikariProxyConnection)ds.getConnection()).delegate.toString().split("@")[1]`
2. Store it compare and profit