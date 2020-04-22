
#!/bin/bash

echo "Creating KMS KEY..."
KMS_KEY=`./create-key.sh | jq ".KeyMetadata.Arn"`
#KMS_KEY="arn:aws:kms:us-east-1:000000000000:key/76ef1dda-fcff-46cf-9ccf-5144531298e0"
# This | xargs does the String.trim which is needed otherwise gets messed up. Dont touch this :-)
KMS_KEY=`echo $KMS_KEY | xargs`
export KMS_KEY
echo "KEY ARN: $KMS_KEY"
sleep 2
echo "KMS Key: $(awslocal kms list-keys | grep $KMS_KEY)"
./mvnw exec:java \
  -Dexec.mainClass="Main" -Dexec.args="" -DKMS_KEY='$KMS_KEY' -Dexec.classpathScope=runtime