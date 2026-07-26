package com.diegopacheco.floci.config;

import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kafka.KafkaClient;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsConfig {
    private final URI endpoint;
    private final Region region;
    private final StaticCredentialsProvider credentials;

    public AwsConfig(
            @Value("${aws.endpoint}") URI endpoint,
            @Value("${aws.region}") String region,
            @Value("${aws.access-key}") String accessKey,
            @Value("${aws.secret-key}") String secretKey) {
        this.endpoint = endpoint;
        this.region = Region.of(region);
        this.credentials = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));
    }

    @Bean
    SqsClient sqsClient() {
        return SqsClient.builder()
                .endpointOverride(endpoint)
                .region(region)
                .credentialsProvider(credentials)
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .build();
    }

    @Bean
    SnsClient snsClient() {
        return SnsClient.builder()
                .endpointOverride(endpoint)
                .region(region)
                .credentialsProvider(credentials)
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .build();
    }

    @Bean
    KinesisClient kinesisClient() {
        return KinesisClient.builder()
                .endpointOverride(endpoint)
                .region(region)
                .credentialsProvider(credentials)
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .build();
    }

    @Bean
    KafkaClient kafkaClient() {
        return KafkaClient.builder()
                .endpointOverride(endpoint)
                .region(region)
                .credentialsProvider(credentials)
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .build();
    }

    @Bean
    S3Client s3Client() {
        return S3Client.builder()
                .endpointOverride(endpoint)
                .region(region)
                .credentialsProvider(credentials)
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .serviceConfiguration(S3Configuration.builder().pathStyleAccessEnabled(true).build())
                .build();
    }
}
