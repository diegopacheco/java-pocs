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

### 3CP0 Notes
* https://www.mchange.com/projects/c3p0/apidocs/com/mchange/v2/c3p0/management/PooledDataSourceManagerMBean.html
* https://www.mchange.com/projects/c3p0/apidocs/com/mchange/v2/c3p0/management/C3P0RegistryManagerMBean.html

### DBCP2 Notes
* https://commons.apache.org/proper/commons-dbcp/api-2.7.0/org/apache/commons/dbcp2/BasicDataSource.html#evict--

### Interesting Reading

Bad Behavior: Handling Database Down <br/>
https://github.com/brettwooldridge/HikariCP/wiki/Bad-Behavior:-Handling-Database-Down

Hikari Configuration <br/>
https://github.com/brettwooldridge/HikariCP?tab=readme-ov-file#gear-configuration-knobs-baby