
#!/bin/bash
export AWS_PROFILE="default"
./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime
