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
// 20250119012047
// http://localhost:8080/all

[
  {
    "id": 1,
    "firstName": "****",
    "lastName": "****"
  },
  {
    "id": 2,
    "firstName": "****",
    "lastName": "****"
  },
  {
    "id": 3,
    "firstName": "****",
    "lastName": "****"
  },
  {
    "id": 4,
    "firstName": "****",
    "lastName": "****"
  },
  {
    "id": 5,
    "firstName": "****",
    "lastName": "****"
  },
  {
    "id": 6,
    "firstName": "****",
    "lastName": "****"
  },
  ...
```