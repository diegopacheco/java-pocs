### Build 

```bash
./mvnw clean install 
```

### Result

```
[INFO] Scanning for projects...
[INFO]
[INFO] ------< com.github.diegopacheco.javapocs:java-25-apache-calcite >-------
[INFO] Building java-25-apache-calcite 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ java-25-apache-calcite ---
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Parsed SQL: SELECT `NAME`, `AGE`
FROM `USERS`
WHERE `AGE` > 21
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.318 s
[INFO] Finished at: 2025-09-22T21:14:13-07:00
[INFO] ------------------------------------------------------------------------
```


