#!/bin/bash

echo '#!/bin/bash' > runme
echo "echo \"Running Bash and them java\"" >> runme
echo "exec java -jar \$0 \"\$@\" " >> runme
cat target/self-executable-bash-java-1.0-SNAPSHOT.jar >> runme
chmod +x ./runme

echo "Build is done!"