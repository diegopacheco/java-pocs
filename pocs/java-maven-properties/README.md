### Build 
```bash
./mvnw clean install 
```

### Result

target/classes/properties-from-pom.properties
```
❯ cat target/classes/properties-from-pom.properties
#Properties
#Thu Sep 19 00:44:02 PDT 2024
maven.compiler.source=21
maven.compiler.target=21
name=java-maven-properties
version=1.0-SNAPSHOT
```

```
./run.sh
```
```
❯ ./run.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------< com.github.diegopacheco.javapocs:java-maven-properties >-------
[INFO] Building java-maven-properties 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.1.0:java (default-cli) @ java-maven-properties ---
21
java-maven-properties
1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.553 s
[INFO] Finished at: 2024-09-19T00:44:13-07:00
[INFO] ------------------------------------------------------------------------
```