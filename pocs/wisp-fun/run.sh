
#!/bin/bash
./mvnw clean compile -q
java --enable-preview -cp target/classes:$(./mvnw dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q) Main

