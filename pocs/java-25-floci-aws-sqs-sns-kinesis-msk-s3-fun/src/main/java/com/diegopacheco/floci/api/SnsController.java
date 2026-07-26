package com.diegopacheco.floci.api;

import static com.diegopacheco.floci.api.ApiModels.ReadResponse;
import static com.diegopacheco.floci.api.ApiModels.WriteRequest;
import static com.diegopacheco.floci.api.ApiModels.WriteResponse;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.QueueAttributeName;
import software.amazon.awssdk.services.sqs.model.QueueDoesNotExistException;

@RestController
@RequestMapping("/api/sns")
public class SnsController {
    private final SnsClient sns;
    private final SqsClient sqs;
    private final String topicName;
    private final String queueName;

    public SnsController(
            SnsClient sns,
            SqsClient sqs,
            @Value("${resources.sns-topic}") String topicName,
            @Value("${resources.sns-queue}") String queueName) {
        this.sns = sns;
        this.sqs = sqs;
        this.topicName = topicName;
        this.queueName = queueName;
    }

    @PostMapping
    WriteResponse write(@RequestBody WriteRequest request) {
        requireValue(request);
        String topicArn = topicArn();
        subscribe(topicArn);
        var response = sns.publish(builder -> builder.topicArn(topicArn).message(request.value()));
        return new WriteResponse("sns", response.messageId(), request.value());
    }

    @GetMapping
    ReadResponse read() {
        String queueUrl = queueUrl();
        var response = sqs.receiveMessage(builder -> builder.queueUrl(queueUrl).maxNumberOfMessages(10));
        response.messages().forEach(message -> sqs.deleteMessage(builder -> builder.queueUrl(queueUrl).receiptHandle(message.receiptHandle())));
        return new ReadResponse("sns", response.messages().stream().map(message -> message.body()).toList());
    }

    private String topicArn() {
        return sns.createTopic(builder -> builder.name(topicName)).topicArn();
    }

    private String queueUrl() {
        try {
            return sqs.getQueueUrl(builder -> builder.queueName(queueName)).queueUrl();
        } catch (QueueDoesNotExistException exception) {
            return sqs.createQueue(builder -> builder.queueName(queueName)).queueUrl();
        }
    }

    private void subscribe(String topicArn) {
        String queueUrl = queueUrl();
        String queueArn = sqs.getQueueAttributes(builder -> builder.queueUrl(queueUrl).attributeNames(QueueAttributeName.QUEUE_ARN))
                .attributes()
                .get(QueueAttributeName.QUEUE_ARN);
        boolean subscribed = sns.listSubscriptionsByTopic(builder -> builder.topicArn(topicArn))
                .subscriptions()
                .stream()
                .anyMatch(subscription -> queueArn.equals(subscription.endpoint()));
        if (!subscribed) {
            sns.subscribe(builder -> builder
                    .topicArn(topicArn)
                    .protocol("sqs")
                    .endpoint(queueArn)
                    .attributes(Map.of("RawMessageDelivery", "true")));
        }
    }

    private void requireValue(WriteRequest request) {
        if (request == null || request.value() == null || request.value().isBlank()) {
            throw new IllegalArgumentException("value is required");
        }
    }
}
