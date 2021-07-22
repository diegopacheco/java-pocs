package com.github.diegopacheco.cw.custom.metrics;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.*;

import java.util.Map;

public class CWMetricsPublisher implements MetricsPublisher {

    private AmazonCloudWatch acw;

    public CWMetricsPublisher(){
        connect();
    }

    private void connect(){
        if (!TagManager.isTestModeON()){
            acw = AmazonCloudWatchClientBuilder.
                    standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        }else{
            acw = AmazonCloudWatchClientBuilder.
                    standard().
                    withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "http://localhost:4566",
                                Regions.US_WEST_2.getName())
                    ).
                    build();
        }
    }

    @Override
    public int publish(String name,Double value, Map<String, String> tags) {

        Dimension[] dimensions = toDimensions(tags);

        MetricDatum datum = new MetricDatum()
                .withMetricName(name)
                .withUnit(StandardUnit.None)
                .withValue(value)
                .withDimensions(dimensions);

        PutMetricDataRequest request = new PutMetricDataRequest()
                .withNamespace("APP/METRICS/")
                .withMetricData(datum);

        PutMetricDataResult response = acw.putMetricData(request);
        return response.getSdkHttpMetadata().getHttpStatusCode();
    }

    private Dimension[] toDimensions(Map<String, String> tags){
        Dimension[] dimensions = new Dimension[tags.keySet().size()];
        int i=0;
        for(String key: tags.keySet()){
            dimensions[i] = new Dimension().withName(key).withValue(tags.get(key));
            i++;
        }
        return dimensions;
    }
}
