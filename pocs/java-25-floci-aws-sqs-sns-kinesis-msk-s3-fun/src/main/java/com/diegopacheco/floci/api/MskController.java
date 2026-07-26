package com.diegopacheco.floci.api;

import static com.diegopacheco.floci.api.ApiModels.ReadResponse;
import static com.diegopacheco.floci.api.ApiModels.WriteRequest;
import static com.diegopacheco.floci.api.ApiModels.WriteResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.kafka.KafkaClient;
import software.amazon.awssdk.services.kafka.model.BrokerNodeGroupInfo;

@RestController
@RequestMapping("/api/msk")
public class MskController {
    private final KafkaClient kafka;
    private final String kafkaVersion;

    public MskController(KafkaClient kafka, @Value("${resources.msk-kafka-version}") String kafkaVersion) {
        this.kafka = kafka;
        this.kafkaVersion = kafkaVersion;
    }

    @PostMapping
    WriteResponse write(@RequestBody WriteRequest request) {
        requireValue(request);
        var existing = kafka.listClustersV2(builder -> {
                }).clusterInfoList().stream()
                .filter(cluster -> request.value().equals(cluster.clusterName()))
                .findFirst();
        if (existing.isPresent()) {
            return new WriteResponse("msk", existing.get().clusterArn(), request.value());
        }
        var response = kafka.createCluster(builder -> builder
                .clusterName(request.value())
                .kafkaVersion(kafkaVersion)
                .numberOfBrokerNodes(2)
                .brokerNodeGroupInfo(BrokerNodeGroupInfo.builder()
                        .instanceType("kafka.m5.large")
                        .clientSubnets("subnet-floci-a", "subnet-floci-b")
                        .build()));
        return new WriteResponse("msk", response.clusterArn(), request.value());
    }

    @GetMapping
    ReadResponse read() {
        return new ReadResponse("msk", kafka.listClustersV2(builder -> {
                })
                .clusterInfoList()
                .stream()
                .map(cluster -> cluster.clusterName())
                .toList());
    }

    private void requireValue(WriteRequest request) {
        if (request == null || request.value() == null || request.value().isBlank()) {
            throw new IllegalArgumentException("value is required");
        }
    }
}
