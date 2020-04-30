#!/bin/bash

echo "Creating KMS KEY..."
KMS_CUSTOMER_MANAGED_CMK_KEY=`./create-key.sh | jq ".KeyMetadata.Arn"`
#KMS_CUSTOMER_MANAGED_CMK_KEY="arn:aws:kms:us-east-1:000000000000:key/76ef1dda-fcff-46cf-9ccf-5144531298e0"

# This | xargs does the String.trim which is needed otherwise gets messed up. Don't touch this :-)
KMS_CUSTOMER_MANAGED_CMK_KEY=`echo $KMS_CUSTOMER_MANAGED_CMK_KEY | xargs`
export KMS_CUSTOMER_MANAGED_CMK_KEY
echo "KEY ARN: $KMS_CUSTOMER_MANAGED_CMK_KEY"
sleep 2
echo "KMS_CUSTOMER_MANAGED_CMK_KEY: $(awslocal kms list-keys | grep $KMS_CUSTOMER_MANAGED_CMK_KEY)"
./mvnw exec:java \
  -Dexec.mainClass="Main" -Dexec.args="" -DKMS_CUSTOMER_MANAGED_CMK_KEY='$KMS_CUSTOMER_MANAGED_CMK_KEY' -Dexec.classpathScope=runtime