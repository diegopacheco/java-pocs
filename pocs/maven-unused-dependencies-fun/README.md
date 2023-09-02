### Build 
```bash
./mvnw clean install 
```

### Result
```bash
mvn dependency:analyze
```
```
[INFO] --- dependency:3.6.0:analyze (default-cli) @ maven-unused-dependencies-fun ---
[WARNING] Unused declared dependencies found:
[WARNING]    commons-collections:commons-collections:jar:3.2.2:compile
[WARNING]    org.apache.commons:commons-lang3:jar:3.13.0:compile
[WARNING]    org.junit.jupiter:junit-jupiter-api:jar:5.9.3:test
[WARNING]    org.apache.logging.log4j:log4j-api:jar:2.20.0:compile
[WARNING]    org.apache.logging.log4j:log4j-core:jar:2.20.0:compile

```