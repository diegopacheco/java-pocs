### Simple Maven Plugin

* Java 23
* Maven 3.9.x plugin
* Simple
* Working with exemple of consumer (sample/pom.xml)

### Build 

```bash
./mvnw clean install 
```
```
❯ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------< com.github.diegopacheco.javapocs:simple-maven-plugin >--------
[INFO] Building simple-maven-plugin 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] ----------------------------[ maven-plugin ]----------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ simple-maven-plugin ---
[INFO] Deleting /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/simple-maven-plugin/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ simple-maven-plugin ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.14.0:compile (default-compile) @ simple-maven-plugin ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug target 23] to target/classes
[INFO] 
[INFO] --- plugin:3.13.0:descriptor (default-descriptor) @ simple-maven-plugin ---
[INFO] Using 'UTF-8' encoding to read mojo source files.
[INFO] java-annotations mojo extractor found 1 mojo descriptor.
[INFO] java-javadoc mojo extractor found 0 mojo descriptor.
[INFO] ant mojo extractor found 0 mojo descriptor.
[INFO] bsh mojo extractor found 0 mojo descriptor.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ simple-maven-plugin ---
[INFO] Copying 0 resource from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.14.0:testCompile (default-testCompile) @ simple-maven-plugin ---
[INFO] Recompiling the module because of changed dependency.
[INFO] 
[INFO] --- surefire:3.5.2:test (default-test) @ simple-maven-plugin ---
[INFO] 
[INFO] --- jar:3.3.0:jar (default-jar) @ simple-maven-plugin ---
[INFO] Building jar: /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/simple-maven-plugin/target/simple-maven-plugin-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- plugin:3.13.0:addPluginArtifactMetadata (default-addPluginArtifactMetadata) @ simple-maven-plugin ---
[INFO] This Mojo is not used in Maven version 3.9.0 and above
[INFO] 
[INFO] --- install:3.1.1:install (default-install) @ simple-maven-plugin ---
[INFO] Installing /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/simple-maven-plugin/pom.xml to /home/diego/.m2/repository/com/github/diegopacheco/javapocs/simple-maven-plugin/1.0-SNAPSHOT/simple-maven-plugin-1.0-SNAPSHOT.pom
[INFO] Installing /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/simple-maven-plugin/target/simple-maven-plugin-1.0-SNAPSHOT.jar to /home/diego/.m2/repository/com/github/diegopacheco/javapocs/simple-maven-plugin/1.0-SNAPSHOT/simple-maven-plugin-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.852 s
[INFO] Finished at: 2025-05-31T12:01:46-07:00
[INFO] ------------------------------------------------------------------------
```

### Result

sample/pom.xml
```
❯ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------< com.github.diegopacheco.javapocs:sample-consumer >----------
[INFO] Building sample-consumer 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ sample-consumer ---
[INFO] Deleting /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/simple-maven-plugin/sample/target
[INFO] 
[INFO] --- simple:1.0-SNAPSHOT:smp (run-hello) @ sample-consumer ---
[INFO] ************** Simple Maven Plugin **************
[INFO] Hello, Maven Plugin User from your Maven Plugin!
[INFO] **************************************************
[INFO] 
[INFO] --- install:3.1.1:install (default-install) @ sample-consumer ---
[INFO] Installing /mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/simple-maven-plugin/sample/pom.xml to /home/diego/.m2/repository/com/github/diegopacheco/javapocs/sample-consumer/1.0-SNAPSHOT/sample-consumer-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.704 s
[INFO] Finished at: 2025-05-31T12:02:10-07:00
[INFO] ------------------------------------------------------------------------
```


