
#!/bin/bash
export AWS_PROFILE="default"
export KMS_KEY=$(./create-key.sh | jq ".KeyMetadata.Arn")
sleep 3
./mvnw exec:java -Dexec.mainClass="Main"-DKMS_KEY=$KMS_KEY -Dexec.classpathScope=runtime
