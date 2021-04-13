
#!/bin/bash

./mvnw exec:java -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector \
-Dexec.mainClass="Main" -Dexec.classpathScope=runtime

