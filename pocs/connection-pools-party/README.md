### Build 
```bash
./mvnw clean install 
```

### Hikari Notes
`ds.getHikariPoolMXBean().softEvictConnections();`

Key Classes and methods:
* com.zaxxer.hikari.pool.HikariPool.softEvictConnections
  * com.zaxxer.hikari.pool.HikariPool.softEvictConnection
    * com.zaxxer.hikari.pool.HikariPool.closeConnection
      * com.zaxxer.hikari.pool.PoolBase.quietlyCloseConnection (set network timeout 1.5s)
    * com.zaxxer.hikari.pool.HikariPool.fillPool
      * com.zaxxer.hikari.pool.HikariPool.PoolEntryCreator.call
        * com.zaxxer.hikari.pool.HikariPool.createPoolEntry
          * com.zaxxer.hikari.pool.PoolBase.newConnection

Order of Events:
1. First it mark to close the connection
2. IF is ACTIVE it will close after connection is closed
3. If IS IDLE close right the way
4. When it evits it first close a connection and them create a new one.
  * `com.zaxxer.hikari.pool.PoolBase.quietlyCloseConnection`
  * `com.zaxxer.hikari.pool.PoolBase.newConnection`

Observations:

** Does not allow us to change the JDBC URL (Only user/password)

** Hikari is full of service pools.

** Refresh is working.

### 3CP0 Notes
* https://www.mchange.com/projects/c3p0/apidocs/com/mchange/v2/c3p0/management/PooledDataSourceManagerMBean.html
* https://www.mchange.com/projects/c3p0/apidocs/com/mchange/v2/c3p0/management/C3P0RegistryManagerMBean.html

`ds.softReset("root","pass");`

Key Classes and methods:
* com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource.softReset
  * com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool.reset
    * com.mchange.v2.resourcepool.BasicResourcePool.resetPool
      * com.mchange.v2.resourcepool.BasicResourcePool.markBrokenNoEnsureMinResources 
      *  com.mchange.v2.resourcepool.BasicResourcePool.ensureMinResources

Order of Events:
1. Make each connection as broken (does not enforce nim resource)
2. After closing all connections
3. Resize the pool and create all new ones necessary

Observation:

** Allow us to change the JDBC URL and user/password

** 3CP0 is full of locks and synchronized blocks.

** Refresh is working.

### DBCP2 Notes
* https://commons.apache.org/proper/commons-dbcp/api-2.7.0/org/apache/commons/dbcp2/BasicDataSource.html#evict--
* org.apache.commons.pool2.impl.GenericObjectPool.evict
* org.apache.commons.pool2.impl.DefaultEvictionPolicy
```
 Objects will be evicted if the following conditions are met:
 
 The object has been idle longer than
      GenericObjectPool#getMinEvictableIdleDuration() /
      GenericKeyedObjectPool#getMinEvictableIdleDuration()
 There are more than GenericObjectPool#getMinIdle() /
      GenericKeyedObjectPoolConfig#getMinIdlePerKey() idle objects in
 The pool and the object has been idle for longer than
      GenericObjectPool#getSoftMinEvictableIdleDuration() /
      GenericKeyedObjectPool#getSoftMinEvictableIdleDuration()
 ```

`connectionPool.evict();`

* org.apache.commons.pool2.impl.GenericObjectPool.evict

Observations:

** Does not Allow to Change anything (user,pass,url)

** If you ask for more connections that are in the pool (there is a lock) 

** Because of the policies, it's not guarantee that when call `connectionPool.evict();` will evit.

** I had to create my own policy to force evition to happen.

** Because the logs are not very clear, IDK if the pool is working 100%, but I see evition code happening now
```
511138550, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
867055874, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
397047147, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
132110886, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
981768141, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
754531696, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
1994771143, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J

1348379859, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
558811593, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
248412663, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
844497378, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
1328207774, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
42229153, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
934030689, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J

400885600, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
1405636728, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
348822292, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
1121680329, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
2109389557, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
1826647722, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
749881881, URL=jdbc:mysql://127.0.0.1:3325/person, MySQL Connector/J
```
List 2 and 3 should be different. All 3 lists are different which is weired.

** DBCP 2 code is more complex to understand.

### Interesting Reading

Bad Behavior: Handling Database Down <br/>
https://github.com/brettwooldridge/HikariCP/wiki/Bad-Behavior:-Handling-Database-Down

Hikari Configuration <br/>
https://github.com/brettwooldridge/HikariCP?tab=readme-ov-file#gear-configuration-knobs-baby