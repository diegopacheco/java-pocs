package com.diegopacheco.floci.api;

import static com.diegopacheco.floci.api.ApiModels.ReadResponse;
import static com.diegopacheco.floci.api.ApiModels.WriteRequest;
import static com.diegopacheco.floci.api.ApiModels.WriteResponse;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.QueueDoesNotExistException;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

@RestController
@RequestMapping("/api/sqs")
public class SqsController {
    private final SqsClient sqs;
    private final String queueName;

    public SqsController(SqsClient sqs, @Value("${resources.sqs-queue}") String queueName) {
        this.sqs = sqs;
        this.queueName = queueName;
    }

    @PostMapping
    WriteResponse write(@RequestBody WriteRequest request) {
        requireValue(request);
        var response = sqs.sendMessage(builder -> builder.queueUrl(queueUrl()).messageBody(request.value()));
        return new WriteResponse("sqs", response.messageId(), request.value());
    }

    @GetMapping
    ReadResponse read() {
        ReceiveMessageResponse response = sqs.receiveMessage(builder -> builder.queueUrl(queueUrl()).maxNumberOfMessages(10));
        response.messages().forEach(message -> sqs.deleteMessage(builder -> builder.queueUrl(queueUrl()).receiptHandle(message.receiptHandle())));
        return new ReadResponse("sqs", response.messages().stream().map(message -> message.body()).toList());
    }

    private String queueUrl() {
        try {
            return sqs.getQueueUrl(builder -> builder.queueName(queueName)).queueUrl();
        } catch (QueueDoesNotExistException exception) {
            return sqs.createQueue(builder -> builder.queueName(queueName)).queueUrl();
        }
    }

    private void requireValue(WriteRequest request) {
        if (request == null || request.value() == null || request.value().isBlank()) {
            throw new IllegalArgumentException("value is required");
        }
    }
}
