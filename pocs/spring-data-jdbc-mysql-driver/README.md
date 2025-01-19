### Build

```bash
./mvnw clean install
```

### Mapping

Person.java
```Java
public class Person {

    @Id
    private long id;

    @Anonymizing(dbFieldName = "first_name", strategy = AnonymizingStrategy.LAST4)
    private String firstName;

    @Anonymizing(dbFieldName = "last_name", strategy = AnonymizingStrategy.STAR)
    private String lastName;
 
    // ...
}
```

### Enable Anonymizing Driver

```Java 
@Configuration
public class DBConfiguration {

    @Bean
    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        config.setUsername( "root" );
        config.setPassword( "pass" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("com.github.diegopacheco.sandboxspring.driver.AnonymizingMySQLDriver");
        return new HikariDataSource( config );
    }

}
```

### Result

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.1)

2025-01-19T02:15:35.073-08:00  INFO 3450796 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-01-19T02:15:35.075-08:00  INFO 3450796 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.34]
2025-01-19T02:15:35.109-08:00  INFO 3450796 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
[AnonymizingMySQLDriver] ***** created!
[AnonymizingMySQLDriver] ***** registered!
[AnonymizingMySQLDriver] ***** created!
2025-01-19T02:15:35.311-08:00  INFO 3450796 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
[AnonymizingMySQLDriver] ***** connect called!
2025-01-19T02:15:35.708-08:00  INFO 3450796 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
[AnonymizingMySQLDriver] ***** connect called!
2025-01-19T02:15:36.689-08:00  INFO 3450796 --- [           main] org.reflections.Reflections              : Reflections took 39 ms to scan 1 urls, producing 3 keys and 8 values
Spring Boot 3.4.1 up and running! 
DB Loader done. 
```

http://localhost:8080/all
```
// 20250119021147
// http://localhost:8080/all

[
  {
    "id": 1,
    "firstName": "**ctor",
    "lastName": "****"
  },
  {
    "id": 2,
    "firstName": "*ante",
    "lastName": "*********"
  },
  {
    "id": 3,
    "firstName": "**efan",
    "lastName": "*****"
  },
  {
    "id": 4,
    "firstName": "*scar",
    "lastName": "*****"
  },
  {
    "id": 5,
    "firstName": "*iego",
    "lastName": "*******"
  },
  {
    "id": 6,
    "firstName": "**ctor",
    "lastName": "****"
  },
  ...
```