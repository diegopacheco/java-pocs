### Build

```bash
./mvnw clean install
```

### Partition Definition

```
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `activated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `name_first_char` varchar(1) COLLATE utf8mb4_unicode_ci GENERATED ALWAYS AS (left(upper(`name`),1)) STORED NOT NULL,
  PRIMARY KEY (`id`,`name_first_char`),
  UNIQUE KEY `unique_email` (`email`,`name_first_char`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
PARTITION BY LIST  COLUMNS(name_first_char)
(PARTITION p_a_c VALUES IN ('A','B','C') ENGINE = InnoDB,
 PARTITION p_d_f VALUES IN ('D','E','F') ENGINE = InnoDB,
 PARTITION p_g_i VALUES IN ('G','H','I') ENGINE = InnoDB,
 PARTITION p_j_l VALUES IN ('J','K','L') ENGINE = InnoDB,
 PARTITION p_m_o VALUES IN ('M','N','O') ENGINE = InnoDB,
 PARTITION p_p_r VALUES IN ('P','Q','R') ENGINE = InnoDB,
 PARTITION p_s_u VALUES IN ('S','T','U') ENGINE = InnoDB,
 PARTITION p_v_z VALUES IN ('V','W','X','Y','Z') ENGINE = InnoDB,
 PARTITION p_other VALUES IN ('0','1','2','3','4','5','6','7','8','9') ENGINE = InnoDB)
```

### Partition Evidence

<a href="https://github.com/diegopacheco/java-pocs/blob/master/pocs/java-21-spring-boot-3-mysql-partition/PARTITIONING_EVIDENCE.md">Partitioning Evidence</a>

```bash
./test-partition.sh
```

```
❯ ./test-partitioning.sh
### Check partition information:
mysql: [Warning] Using a password on the command line interface can be insecure.
TABLE_NAME	PARTITION_NAME	PARTITION_EXPRESSION	PARTITION_DESCRIPTION	TABLE_ROWS
users	p_a_c	`name_first_char`	'A','B','C'	3
### Query users from specific partition:
mysql: [Warning] Using a password on the command line interface can be insecure.
name	name_first_char
David	D
### Show query execution plan (partition pruning):
mysql: [Warning] Using a password on the command line interface can be insecure.
id	select_type	table	partitions	type	possible_keys	key	key_len	ref	rows	filtered	Extra
1	SIMPLE	users	p_a_c,p_d_f,p_g_i,p_j_l,p_m_o,p_p_r,p_s_u,p_v_z,p_other	ref	idx_name	idx_name	1022	const	1	100.00	NULL
```

### Result

```bash
./start.sh
```

```
❯ ./start.sh
[+] Running 3/2
 ✔ Network java-21-spring-boot-3-mysql-partition_default  Created                                                                                                0.0s 
 ✔ Container mysql-partition                              Created                                                                                                0.1s 
 ✔ Container spring-boot-app                              Created                                                                                                0.0s 
Attaching to mysql-partition, spring-boot-app
mysql-partition  | 2025-08-29 06:29:34+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 9.0.1-1.el9 started.
mysql-partition  | 2025-08-29 06:29:34+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
mysql-partition  | 2025-08-29 06:29:34+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 9.0.1-1.el9 started.
mysql-partition  | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'
mysql-partition  | 2025-08-29T06:29:35.210608Z 0 [System] [MY-015015] [Server] MySQL Server - start.
mysql-partition  | 2025-08-29T06:29:35.470513Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 9.0.1) starting as process 1
mysql-partition  | 2025-08-29T06:29:35.483128Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
mysql-partition  | 2025-08-29T06:29:35.877390Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
mysql-partition  | 2025-08-29T06:29:36.140693Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
mysql-partition  | 2025-08-29T06:29:36.140715Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
mysql-partition  | 2025-08-29T06:29:36.149506Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
mysql-partition  | 2025-08-29T06:29:36.186599Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
mysql-partition  | 2025-08-29T06:29:36.186678Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '9.0.1'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.
spring-boot-app  | 
spring-boot-app  |   .   ____          _            __ _ _
spring-boot-app  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
spring-boot-app  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
spring-boot-app  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
spring-boot-app  |   '  |____| .__|_| |_|_| |_\__, | / / / /
spring-boot-app  |  =========|_|==============|___/=/_/_/_/
spring-boot-app  | 
spring-boot-app  |  :: Spring Boot ::                (v3.5.5)
spring-boot-app  | 
spring-boot-app  | 2025-08-29T06:30:06.435Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : Starting Application v1.0-SNAPSHOT using Java 23 with PID 1 (/app/app.war started by root in /app)
spring-boot-app  | 2025-08-29T06:30:06.438Z DEBUG 1 --- [           main] c.g.d.sandboxspring.Application          : Running with Spring Boot v3.5.5, Spring v6.2.10
spring-boot-app  | 2025-08-29T06:30:06.439Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : The following 1 profile is active: "default"
spring-boot-app  | 2025-08-29T06:30:07.535Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
spring-boot-app  | 2025-08-29T06:30:07.595Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 52 ms. Found 1 JDBC repository interface.
spring-boot-app  | 2025-08-29T06:30:08.084Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
spring-boot-app  | 2025-08-29T06:30:08.105Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
spring-boot-app  | 2025-08-29T06:30:08.105Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.44]
spring-boot-app  | 2025-08-29T06:30:08.165Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
spring-boot-app  | 2025-08-29T06:30:08.167Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1648 ms
spring-boot-app  | 2025-08-29T06:30:08.513Z DEBUG 1 --- [           main] o.s.jdbc.datasource.DataSourceUtils      : Fetching JDBC Connection from DataSource
spring-boot-app  | 2025-08-29T06:30:08.514Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
spring-boot-app  | 2025-08-29T06:30:08.852Z  INFO 1 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@2bba35ef
spring-boot-app  | 2025-08-29T06:30:08.859Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
spring-boot-app  | 2025-08-29T06:30:09.686Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
spring-boot-app  | 2025-08-29T06:30:09.797Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
spring-boot-app  | 2025-08-29T06:30:09.818Z  INFO 1 --- [           main] c.g.d.sandboxspring.Application          : Started Application in 3.964 seconds (process running for 4.494)
spring-boot-app  | Spring Boot 3.5.x working! 
spring-boot-app  | 2025-08-29T06:30:16.880Z  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
spring-boot-app  | 2025-08-29T06:30:16.881Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
spring-boot-app  | 2025-08-29T06:30:16.882Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
spring-boot-app  | 2025-08-29T06:30:16.931Z DEBUG 1 --- [nio-8080-exec-1] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL query
spring-boot-app  | 2025-08-29T06:30:16.931Z DEBUG 1 --- [nio-8080-exec-1] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL statement [SELECT * FROM users]
spring-boot-app  | 2025-08-29T06:30:16.932Z DEBUG 1 --- [nio-8080-exec-1] o.s.jdbc.datasource.DataSourceUtils      : Fetching JDBC Connection from DataSource
```

