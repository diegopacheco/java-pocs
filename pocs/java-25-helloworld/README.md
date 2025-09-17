### Build 

```bash
./mvnw clean install 
```

### Result

java -version
```
❯ java -version
openjdk version "25" 2025-09-16 LTS
OpenJDK Runtime Environment Zulu25.28+85-CA (build 25+36-LTS)
OpenJDK 64-Bit Server VM Zulu25.28+85-CA (build 25+36-LTS, mixed mode, sharing)
```

./run.sh
```
[INFO] Scanning for projects...
[INFO]
[INFO] --------< com.github.diegopacheco.javapocs:java-25-helloworld >---------
[INFO] Building java-25-helloworld 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ java-25-helloworld ---
It works!
Java version: 25
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.126 s
[INFO] Finished at: 2025-09-16T22:16:49-07:00
[INFO] ------------------------------------------------------------------------
```