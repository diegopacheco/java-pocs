import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

public class Main{
  public static void main(String args[]) throws Exception {
    String inputTopic = "inputTopic";

    Properties streamsConfiguration = new Properties();
    streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-live-test");
    streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG,"/tmp/kafka-streams-tmp/");
    streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");

    final StreamsBuilder builder = new StreamsBuilder();
    KStream<String, String> source = builder.stream(inputTopic);
    Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);

    KTable<Windowed<String>, String> deduplicated = source
            .flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
            .groupBy((key, word) -> word)
            .windowedBy(TimeWindows.of(Duration.ofSeconds(30)))
            .reduce((value1, value2) -> value1); // Deduplicate by keeping the first occurrence

    deduplicated.toStream()
            .map((key, value) -> new KeyValue<>(key.key(), value))
            .to("outputTopic", Produced.with(Serdes.String(), Serdes.String()));

    final KafkaStreams streams = new KafkaStreams(builder.build(), streamsConfiguration);
    streams.start();
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
  }
}