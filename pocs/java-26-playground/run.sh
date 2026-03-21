
#!/bin/bash
./mvnw clean compile -q && java --enable-preview -cp target/classes:$(./mvnw dependency:build-classpath -q -DincludeScope=runtime -Dmdep.outputFile=/dev/stdout) Main
