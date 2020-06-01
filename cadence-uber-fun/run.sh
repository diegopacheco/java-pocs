
#!/bin/bash

#./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime
docker run --network=host --rm ubercadence/cli:master --do test-domain workflow start --tasklist HelloWorldTaskList --workflow_type HelloWorld::sayHello --execution_timeout 3600 --input \"World\"
