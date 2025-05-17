### Build 

```bash
./mvnw clean install 
```
```
❯ ./mvnw clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ----< com.github.diegopacheco.javapocs:java-23-module-info-system >-----
[INFO] Building java-23-module-info-system 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ java-23-module-info-system ---
[INFO] Deleting /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-23-module-info-system/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ java-23-module-info-system ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ java-23-module-info-system ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 5 source files with javac [forked target 23] to target/classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ java-23-module-info-system ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ java-23-module-info-system ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 3 source files with javac [forked target 23 module-path] to target/test-classes
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ java-23-module-info-system ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.github.diegopacheco.service.test.SimpleCalculatorServiceTest
[INFO] Running com.github.diegopacheco.service.test.AuditMathServiceTest
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.084 s -- in com.github.diegopacheco.service.test.SimpleCalculatorServiceTest
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.095 s -- in com.github.diegopacheco.service.test.AuditMathServiceTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 20, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.3.0:jar (default-jar) @ java-23-module-info-system ---
[INFO] Building jar: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-23-module-info-system/target/java-23-module-info-system-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- install:3.1.1:install (default-install) @ java-23-module-info-system ---
[INFO] Installing /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-23-module-info-system/pom.xml to /home/diego/.m2/repository/com/github/diegopacheco/javapocs/java-23-module-info-system/1.0-SNAPSHOT/java-23-module-info-system-1.0-SNAPSHOT.pom
[INFO] Installing /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/java-23-module-info-system/target/java-23-module-info-system-1.0-SNAPSHOT.jar to /home/diego/.m2/repository/com/github/diegopacheco/javapocs/java-23-module-info-system/1.0-SNAPSHOT/java-23-module-info-system-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.942 s
[INFO] Finished at: 2025-05-16T16:59:06-07:00
[INFO] ------------------------------------------------------------------------
```

### Result

```
❯ ./run.sh
[INFO] Scanning for projects...
[INFO] 
[INFO] ----< com.github.diegopacheco.javapocs:java-23-module-info-system >-----
[INFO] Building java-23-module-info-system 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.5.0:java (default-cli) @ java-23-module-info-system ---
2 + 3 = 5.0
2 - 3 = -1.0
Historical Math Service = {2.0+3.0=5.0, 2.0-3.0=-1.0}
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.545 s
[INFO] Finished at: 2025-05-16T16:59:42-07:00
[INFO] ------------------------------------------------------------------------
```


