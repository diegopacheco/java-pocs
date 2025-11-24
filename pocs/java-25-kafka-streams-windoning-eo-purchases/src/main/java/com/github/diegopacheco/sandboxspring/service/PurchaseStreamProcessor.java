package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PurchaseStreamProcessor {
    private static final String STORE_NAME = "user-total-debt-store";
    private final ObjectMapper objectMapper;
    private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    public PurchaseStreamProcessor(StreamsBuilder streamsBuilder, StreamsBuilderFactoryBean streamsBuilderFactoryBean) {
        this.objectMapper = new ObjectMapper();
        this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;
        buildPipeline(streamsBuilder);
    }

    private void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> purchases = streamsBuilder.stream("purchases",
                Consumed.with(Serdes.String(), Serdes.String()));

        purchases
                .groupByKey(Grouped.with(Serdes.String(), Serdes.String()))
                .aggregate(
                        () -> "0.0",
                        (userId, purchaseJson, currentTotal) -> {
                            try {
                                JsonNode node = objectMapper.readTree(purchaseJson);
                                BigDecimal total = new BigDecimal(node.get("total").asText());
                                BigDecimal current = new BigDecimal(currentTotal);
                                return current.add(total).toString();
                            } catch (Exception e) {
                                return currentTotal;
                            }
                        },
                        Materialized.as(STORE_NAME)
                );
    }

    public BigDecimal getTotalDebt(String userId) {
        try {
            ReadOnlyKeyValueStore<String, String> store = streamsBuilderFactoryBean
                    .getKafkaStreams()
                    .store(org.apache.kafka.streams.StoreQueryParameters.fromNameAndType(
                            STORE_NAME,
                            QueryableStoreTypes.keyValueStore()
                    ));
            String total = store.get(userId);
            return total != null ? new BigDecimal(total) : BigDecimal.ZERO;
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
