
#!/bin/bash

export MAVEN_OPTS="-Xmx1024m"

fallocate -l 4G /tmp/in.txt
echo "4GB input file created at /tmp/in.txt"

./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime

