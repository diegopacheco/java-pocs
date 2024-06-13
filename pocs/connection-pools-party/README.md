### Build 
```bash
./mvnw clean install 
```
### Hikari Notes

`ds.getHikariPoolMXBean().softEvictConnections();`

Key Classes and methods:
 * com.zaxxer.hikari.pool.HikariPool.PoolEntryCreator.call
 * com.zaxxer.hikari.pool.HikariPool.createPoolEntry
 * com.zaxxer.hikari.pool.PoolBase.quietlyCloseConnection
  * com.zaxxer.hikari.pool.PoolBase.newConnection

Order of Events:
1. First it mark to close the connection
2. IF is ACTIVE it will close after connection is closed
3. If IS IDLE close right the way
4. When it evits it first close a connection and them create a new one.
  * `com.zaxxer.hikari.pool.PoolBase.quietlyCloseConnection`
  * `com.zaxxer.hikari.pool.PoolBase.newConnection`
