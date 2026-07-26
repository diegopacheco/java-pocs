package com.diegopacheco.floci.api;

import static com.diegopacheco.floci.api.ApiModels.ReadResponse;
import static com.diegopacheco.floci.api.ApiModels.WriteRequest;
import static com.diegopacheco.floci.api.ApiModels.WriteResponse;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.ResourceNotFoundException;
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;

@RestController
@RequestMapping("/api/kinesis")
public class KinesisController {
    private final KinesisClient kinesis;
    private final String streamName;

    public KinesisController(KinesisClient kinesis, @Value("${resources.kinesis-stream}") String streamName) {
        this.kinesis = kinesis;
        this.streamName = streamName;
    }

    @PostMapping
    WriteResponse write(@RequestBody WriteRequest request) {
        requireValue(request);
        ensureStream();
        var response = kinesis.putRecord(builder -> builder
                .streamName(streamName)
                .partitionKey(UUID.randomUUID().toString())
                .data(SdkBytes.fromUtf8String(request.value())));
        return new WriteResponse("kinesis", response.sequenceNumber(), request.value());
    }

    @GetMapping
    ReadResponse read() {
        ensureStream();
        String shardId = kinesis.describeStream(builder -> builder.streamName(streamName))
                .streamDescription()
                .shards()
                .getFirst()
                .shardId();
        String iterator = kinesis.getShardIterator(builder -> builder
                .streamName(streamName)
                .shardId(shardId)
                .shardIteratorType(ShardIteratorType.TRIM_HORIZON))
                .shardIterator();
        var values = kinesis.getRecords(builder -> builder.shardIterator(iterator).limit(100))
                .records()
                .stream()
                .map(record -> record.data().asString(StandardCharsets.UTF_8))
                .toList();
        return new ReadResponse("kinesis", values);
    }

    private void ensureStream() {
        try {
            kinesis.describeStream(builder -> builder.streamName(streamName));
        } catch (ResourceNotFoundException exception) {
            kinesis.createStream(builder -> builder.streamName(streamName).shardCount(1));
        }
    }

    private void requireValue(WriteRequest request) {
        if (request == null || request.value() == null || request.value().isBlank()) {
            throw new IllegalArgumentException("value is required");
        }
    }
}
