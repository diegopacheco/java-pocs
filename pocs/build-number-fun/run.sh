
#!/bin/bash

#./mvnw exec:java -Dexec.mainClass="com.github.diegopacheco.java.pocs.impl.version.Main" -Dexec.classpathScope=runtime
./mvnw clean install 
java -jar target/build-number-fun-1.0-SNAPSHOT.jar 
