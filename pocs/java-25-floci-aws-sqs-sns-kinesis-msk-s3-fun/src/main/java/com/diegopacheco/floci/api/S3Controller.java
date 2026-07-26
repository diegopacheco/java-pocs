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
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.NoSuchBucketException;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {
    private final S3Client s3;
    private final String bucket;
    private final String key;

    public S3Controller(
            S3Client s3,
            @Value("${resources.s3-bucket}") String bucket,
            @Value("${resources.s3-key}") String key) {
        this.s3 = s3;
        this.bucket = bucket;
        this.key = key;
    }

    @PostMapping
    WriteResponse write(@RequestBody WriteRequest request) {
        requireValue(request);
        ensureBucket();
        s3.putObject(
                builder -> builder.bucket(bucket).key(key).contentType("text/plain"),
                software.amazon.awssdk.core.sync.RequestBody.fromString(request.value()));
        return new WriteResponse("s3", key, request.value());
    }

    @GetMapping
    ReadResponse read() {
        ensureBucket();
        try {
            return new ReadResponse("s3", List.of(s3.getObjectAsBytes(builder -> builder.bucket(bucket).key(key)).asUtf8String()));
        } catch (software.amazon.awssdk.services.s3.model.NoSuchKeyException exception) {
            return new ReadResponse("s3", List.of());
        }
    }

    private void ensureBucket() {
        try {
            s3.headBucket(builder -> builder.bucket(bucket));
        } catch (NoSuchBucketException exception) {
            s3.createBucket(builder -> builder.bucket(bucket));
        }
    }

    private void requireValue(WriteRequest request) {
        if (request == null || request.value() == null || request.value().isBlank()) {
            throw new IllegalArgumentException("value is required");
        }
    }
}
