
#!/bin/bash

echo "Creating KMS KEY..."
export KMS_KEY=$(./create-key.sh | jq ".KeyMetadata.Arn")
echo "KEY ARN: $KMS_KEY"
sleep 10
./mvnw exec:java -Dexec.mainClass="Main"-DKMS_KEY=$KMS_KEY -Dexec.classpathScope=runtime