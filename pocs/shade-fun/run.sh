
#!/bin/bash

./mvnw clean install
java -jar ./target/one-jar.jar 
#./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime
