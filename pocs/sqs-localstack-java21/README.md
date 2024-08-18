### Build 
```bash
./mvnw clean install 
```

### Related Localstack Poc

https://github.com/diegopacheco/devops-playground/tree/master/localstack-sqs

### AWS SQS

1. `What is the AWS SQS MAX limit of messages that can be consumed at once?`

```
The maximum number of messages that can be consumed at once from an AWS SQS queue is 10 messages per request.
```
<br/>
2. `What if long polling could consume how many messages at once?`

```
Long polling does not change the maximum number of messages that can be consumed at once. 
It still remains at 10 messages per request. Long polling simply reduces the number of empty responses 
by allowing the request to wait until a message is available or the timeout is reached.
```

<br/>
3. `What service should be used if you need to consume a lot of messages?`

```
If you need to consume a large number of messages, you might consider using AWS services like Amazon Kinesis / Kafka or 
Amazon SQS with AWS Lambda. Kinesis is designed for real-time data streaming and can handle large volumes of data. 
Using SQS with Lambda allows you to automatically scale the processing of messages by invoking Lambda 
functions in response to new messages in the queue.
```

4. `Amazon SQS has different throughput limits depending on the type of queue:`

```
Standard Queues:
Unlimited Throughput: Standard queues support a nearly 
unlimited number of transactions per second (TPS) per 
API action (SendMessage, ReceiveMessage, DeleteMessage).

FIFO Queues:
Throughput Limits: 
FIFO queues support up to 3,000 messages per second with batching,
or up to 300 messages per second without batching.
```