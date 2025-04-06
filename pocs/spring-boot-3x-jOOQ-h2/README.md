### Rationale

JooQ is a popular Java library for working with SQL
databases. It provides a fluent API for building 
SQL queries and supports code generation for
type-safe access to database tables.
It's like Slick(Scala) but for Java.

### Benefits

* Type-safe SQL queries
* Fluent API for building queries
* Code generation for type-safe access to database tables
* Supports multiple databases

### Build 

```bash
./mvnw clean install 
```

### Generate Sources

In order to compile the Schema into code.

```bash
❯ mvn clean generate-sources
[INFO] Scanning for projects...
[INFO]
[INFO] ------< com.github.diegopacheco.javapocs:spring-boot-3x-jOOQ-h2 >-------
[INFO] Building spring-boot-3x-jOOQ-h2 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.4.1:clean (default-clean) @ spring-boot-3x-jOOQ-h2 ---
[INFO]
[INFO] --- jooq-codegen:3.19.21:generate (jooq-codegen) @ spring-boot-3x-jOOQ-h2 ---
[INFO]

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@  @@        @@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@        @@@@@@@@@@
@@@@@@@@@@@@@@@@  @@  @@    @@@@@@@@@@
@@@@@@@@@@  @@@@  @@  @@    @@@@@@@@@@
@@@@@@@@@@        @@        @@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@        @@        @@@@@@@@@@
@@@@@@@@@@    @@  @@  @@@@  @@@@@@@@@@
@@@@@@@@@@    @@  @@  @@@@  @@@@@@@@@@
@@@@@@@@@@        @@  @  @  @@@@@@@@@@
@@@@@@@@@@        @@        @@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@  @@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  Thank you for using jOOQ 3.19.21 (Build date: 2025-03-11T08:47:49Z)

[INFO]

jOOQ tip of the day: If you're using Liquibase to migrate your schema, the jOOQ code generator can simulate a Liquibase migration to produce its generated code, rather than connecting to an actual database: https://www.jooq.org/doc/latest/manual/code-generation/codegen-liquibase/

[INFO] No <inputCatalog/> was provided. Generating ALL available catalogs instead.
[INFO] License parameters
[INFO] ----------------------------------------------------------
[INFO]   Thank you for using jOOQ and jOOQ's code generator
[INFO]
[INFO] Database parameters
[INFO] ----------------------------------------------------------
[INFO]   dialect                : H2
[INFO]   URL                    : jdbc:h2:mem:test
[INFO]   target dir             : /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-jOOQ-h2/target/generated-sources/jooq
[INFO]   target package         : com.github.diegopacheco.jooq.generated
[INFO]   includes               : [.*]
[INFO]   excludes               : []
[INFO]   includeExcludeColumns  : false
[INFO] ----------------------------------------------------------
[INFO]
[INFO] JavaGenerator parameters
[INFO] ----------------------------------------------------------
[INFO] annotations
[INFO]   generated              : false
[INFO]   JPA                    : false
[INFO]   JPA version            :
[INFO]   validation             : false
[INFO]   spring                 : false
[INFO] comments
[INFO]   comments               : true
[INFO]   on attributes          : true
[INFO]   on catalogs            : true
[INFO]   on columns             : true
[INFO]   on embeddables         : true
[INFO]   on keys                : true
[INFO]   on links               : true
[INFO]   on packages            : true
[INFO]   on parameters          : true
[INFO]   on queues              : true
[INFO]   on routines            : true
[INFO]   on schemas             : true
[INFO]   on sequences           : true
[INFO]   on tables              : true
[INFO]   on udts                : true
[INFO] sources
[INFO]   sources                : true
[INFO]   sources on views       : true
[INFO] global references
[INFO]   global references      : true
[INFO]   catalogs               : true
[INFO]   domains                : true
[INFO]   indexes                : true
[INFO]   keys                   : true
[INFO]   links                  : true
[INFO]   queues                 : true
[INFO]   routines               : true
[INFO]   schemas                : true
[INFO]   sequences              : true
[INFO]   tables                 : true
[INFO]   udts                   : true
[INFO] object types
[INFO]   daos                   : false
[INFO]   indexes                : true
[INFO]   instance fields        : true
[INFO]   interfaces             : false
[INFO]   interfaces (immutable) : false
[INFO]   javadoc                : true
[INFO]   keys                   : true
[INFO]   links                  : true
[INFO]   pojos                  : false
[INFO]   pojos (immutable)      : false
[INFO]   queues                 : true
[INFO]   records                : true
[INFO]   routines               : true
[INFO]   sequences              : true
[INFO]   sequenceFlags          : true
[INFO]   table-valued functions : true
[INFO]   tables                 : true
[INFO]   udts                   : true
[INFO]   relations              : true
[INFO] other
[INFO]   deprecated code        : true
[INFO] ----------------------------------------------------------
[INFO]
[INFO] Generation remarks
[INFO] ----------------------------------------------------------
[INFO]
[INFO] ----------------------------------------------------------
[INFO] Generating catalogs      : Total: 1
[INFO] Version                  : Database version is supported by dialect H2: 2.3.232 (2024-08-11)
[INFO] ARRAYs fetched           : 0 (0 included, 0 excluded)
[INFO] Domains fetched          : 0 (0 included, 0 excluded)
[INFO] Tables fetched           : 1 (1 included, 0 excluded)
[INFO] Embeddables fetched      : 0 (0 included, 0 excluded)
[INFO] Enums fetched            : 0 (0 included, 0 excluded)
[INFO] Packages fetched         : 0 (0 included, 0 excluded)
[INFO] Routines fetched         : 0 (0 included, 0 excluded)
[INFO] Sequences fetched        : 0 (0 included, 0 excluded)
[INFO] No schema version is applied for catalog . Regenerating.
[INFO]
[INFO] Generating catalog       : DefaultCatalog.java
[INFO] ==========================================================
[INFO] Comments fetched         : 0 (0 included, 0 excluded)
[INFO] Generating schemata      : Total: 1
[INFO] No schema version is applied for schema PUBLIC. Regenerating.
[INFO] Generating schema        : Public.java
[INFO] ----------------------------------------------------------
[INFO] UDTs fetched             : 0 (0 included, 0 excluded)
[INFO] Generating tables
[INFO] Generating table         : Users.java [input=USERS, pk=CONSTRAINT_4]
[INFO] Indexes fetched          : 0 (0 included, 0 excluded)
[INFO] Tables generated         : Total: 608.035ms
[INFO] Generating table records
[INFO] Generating record        : UsersRecord.java
[INFO] Table records generated  : Total: 638.635ms, +30.599ms
[INFO] Generating table references
[INFO] Table refs generated     : Total: 641.192ms, +2.557ms
[INFO] Generating Keys
[INFO] Keys generated           : Total: 643.267ms, +2.074ms
[INFO] Generating Indexes
[INFO] Skipping empty indexes
[INFO] Generation finished: PUBLIC: Total: 643.671ms, +0.403ms
[INFO]
[INFO] Affected files: 6
[INFO] Modified files: 6
[INFO] Removing excess files
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.294 s
[INFO] Finished at: 2025-04-06T00:09:32-07:00
[INFO] ------------------------------------------------------------------------
```

### Result

```
/home/diego/.sdkman/candidates/java/23.0.2-amzn/bin/java --enable-preview -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=37757 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-jOOQ-h2/target/classes:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-jooq/3.4.4/spring-boot-starter-jooq-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/3.4.4/spring-boot-starter-jdbc-3.4.4.jar:/home/diego/.m2/repository/com/zaxxer/HikariCP/5.1.0/HikariCP-5.1.0.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.17/slf4j-api-2.0.17.jar:/home/diego/.m2/repository/org/springframework/spring-jdbc/6.2.5/spring-jdbc-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-tx/6.2.5/spring-tx-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-beans/6.2.5/spring-beans-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-core/6.2.5/spring-core-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-jcl/6.2.5/spring-jcl-6.2.5.jar:/home/diego/.m2/repository/org/jooq/jooq/3.19.21/jooq-3.19.21.jar:/home/diego/.m2/repository/io/r2dbc/r2dbc-spi/1.0.0.RELEASE/r2dbc-spi-1.0.0.RELEASE.jar:/home/diego/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.4.4/spring-boot-starter-web-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter/3.4.4/spring-boot-starter-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot/3.4.4/spring-boot-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.4.4/spring-boot-autoconfigure-3.4.4.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.4.4/spring-boot-starter-logging-3.4.4.jar:/home/diego/.m2/repository/ch/qos/logback/logback-classic/1.5.18/logback-classic-1.5.18.jar:/home/diego/.m2/repository/ch/qos/logback/logback-core/1.5.18/logback-core-1.5.18.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/home/diego/.m2/repository/org/slf4j/jul-to-slf4j/2.0.17/jul-to-slf4j-2.0.17.jar:/home/diego/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/diego/.m2/repository/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.4.4/spring-boot-starter-json-3.4.4.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.18.3/jackson-databind-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.18.3/jackson-annotations-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.18.3/jackson-core-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.18.3/jackson-datatype-jdk8-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.18.3/jackson-datatype-jsr310-2.18.3.jar:/home/diego/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.18.3/jackson-module-parameter-names-2.18.3.jar:/home/diego/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.4.4/spring-boot-starter-tomcat-3.4.4.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.39/tomcat-embed-core-10.1.39.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.39/tomcat-embed-el-10.1.39.jar:/home/diego/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.39/tomcat-embed-websocket-10.1.39.jar:/home/diego/.m2/repository/org/springframework/spring-web/6.2.5/spring-web-6.2.5.jar:/home/diego/.m2/repository/io/micrometer/micrometer-observation/1.14.5/micrometer-observation-1.14.5.jar:/home/diego/.m2/repository/io/micrometer/micrometer-commons/1.14.5/micrometer-commons-1.14.5.jar:/home/diego/.m2/repository/org/springframework/spring-webmvc/6.2.5/spring-webmvc-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-aop/6.2.5/spring-aop-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-context/6.2.5/spring-context-6.2.5.jar:/home/diego/.m2/repository/org/springframework/spring-expression/6.2.5/spring-expression-6.2.5.jar:/home/diego/.m2/repository/com/h2database/h2/2.3.232/h2-2.3.232.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-core/2.24.3/log4j-core-2.24.3.jar Application

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-04-06T00:19:44.293-07:00  INFO 1238250 --- [           main] Application                              : Starting Application using Java 23.0.2 with PID 1238250 (/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-jOOQ-h2/target/classes started by diego in /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-jOOQ-h2)
2025-04-06T00:19:44.297-07:00  INFO 1238250 --- [           main] Application                              : No active profile set, falling back to 1 default profile: "default"
2025-04-06T00:19:45.535-07:00  INFO 1238250 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-04-06T00:19:45.550-07:00  INFO 1238250 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-04-06T00:19:45.550-07:00  INFO 1238250 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-04-06T00:19:45.588-07:00  INFO 1238250 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-04-06T00:19:45.589-07:00  INFO 1238250 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1205 ms
2025-04-06T00:19:45.717-07:00  INFO 1238250 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2025-04-06T00:19:45.910-07:00  INFO 1238250 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:testdb user=SA
2025-04-06T00:19:45.912-07:00  INFO 1238250 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2025-04-06T00:19:47.036-07:00  WARN 1238250 --- [           main] o.s.b.a.AutoConfigurationPackages        : @EnableAutoConfiguration was declared on a class in the default package. Automatic @Repository and @Entity scanning is not enabled.
2025-04-06T00:19:47.192-07:00  INFO 1238250 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2025-04-06T00:19:47.384-07:00  INFO 1238250 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-04-06T00:19:47.397-07:00  INFO 1238250 --- [           main] Application                              : Started Application in 3.567 seconds (process running for 3.996)
2025-04-06T00:19:50.205-07:00  INFO 1238250 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-04-06T00:19:50.205-07:00  INFO 1238250 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-04-06T00:19:50.206-07:00  INFO 1238250 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2025-04-06T00:19:50.391-07:00  INFO 1238250 --- [nio-8080-exec-1] org.jooq.Constants                       : 
                                      
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@  @@        @@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@        @@@@@@@@@@
@@@@@@@@@@@@@@@@  @@  @@    @@@@@@@@@@
@@@@@@@@@@  @@@@  @@  @@    @@@@@@@@@@
@@@@@@@@@@        @@        @@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@        @@        @@@@@@@@@@
@@@@@@@@@@    @@  @@  @@@@  @@@@@@@@@@
@@@@@@@@@@    @@  @@  @@@@  @@@@@@@@@@
@@@@@@@@@@        @@  @  @  @@@@@@@@@@
@@@@@@@@@@        @@        @@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@  @@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  Thank you for using jOOQ 3.19.21 (Build date: 2025-03-11T08:47:49Z)
                                      
2025-04-06T00:19:50.392-07:00  INFO 1238250 --- [nio-8080-exec-1] org.jooq.Constants                       : 

jOOQ tip of the day: You can formally nest records directly in SQL by projecting any ROW type: https://www.jooq.org/doc/latest/manual/sql-building/column-expressions/nested-records/

2025-04-06T00:19:50.754-07:00  INFO 1238250 --- [nio-8080-exec-1] o.j.i.D.logVersionSupport                : Version                  : Database version is supported by dialect H2: 2.3.232 (2024-08-11)
```

### Test

```bash
❯ ./test.sh
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 06 Apr 2025 07:19:50 GMT

{"id":5,"name":"Alice","email":null}HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 06 Apr 2025 07:19:50 GMT

[{"id":1,"name":"User 1","email":"user1@example.com"},{"id":2,"name":"User 2","email":"user2@example.com"},{"id":3,"name":"User 1","email":"user1@example.com"},{"id":4,"name":"User 2","email":"user2@example.com"},{"id":5,"name":"Alice","email":null}]HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 06 Apr 2025 07:19:50 GMT

{"id":1,"name":"Alice Updated","email":"user1@example.com"}HTTP/1.1 200
Content-Length: 0
Date: Sun, 06 Apr 2025 07:19:50 GMT
```