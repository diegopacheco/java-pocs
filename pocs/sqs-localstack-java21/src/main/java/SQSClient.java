import com.google.gson.Gson;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SQSClient {
    private SqsClient sqsClient;
    private Gson gson;

    public SQSClient() {
        System.setProperty("AWS_ACCESS_KEY_ID", "000000000000");
        System.setProperty("AWS_SECRET_ACCESS_KEY", "000000000000");
        gson = new Gson();
        sqsClient = SqsClient.builder().
                region(Region.US_EAST_1).
                credentialsProvider(DefaultCredentialsProvider.create()).
                overrideConfiguration(ClientOverrideConfiguration.builder().build()).
                applyMutation(builder -> {
                    builder.endpointOverride(URI.create("http://localhost:4566"));
                }).build();
    }

    public Map<String, Integer> getQueueStats(String queueName) {
        try {
            GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
            String queueUrl = sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl();

            GetQueueAttributesRequest getQueueAttributesRequest = GetQueueAttributesRequest.builder()
                    .queueUrl(queueUrl)
                    .attributeNamesWithStrings("ApproximateNumberOfMessages", "ApproximateNumberOfMessagesNotVisible", "ApproximateNumberOfMessagesDelayed")
                    .build();

            GetQueueAttributesResponse getQueueAttributesResponse = sqsClient.getQueueAttributes(getQueueAttributesRequest);

            Map<String, Integer> stats = new HashMap<>();
            stats.put("ApproximateNumberOfMessages", Integer.parseInt(getQueueAttributesResponse.attributes().getOrDefault("ApproximateNumberOfMessages","0")));
            stats.put("ApproximateNumberOfMessagesNotVisible", Integer.parseInt(getQueueAttributesResponse.attributes().getOrDefault("ApproximateNumberOfMessagesNotVisible","0")));
            stats.put("ApproximateNumberOfMessagesDelayed", Integer.parseInt(getQueueAttributesResponse.attributes().getOrDefault("ApproximateNumberOfMessagesDelayed","0")));

            return stats;
        } catch (SqsException e) {
            System.err.println("SQS error: " + e.awsErrorDetails().errorMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public SendMessageResponse sendMessage(String queueName, String message) {
        try {
            String jsonMessage = gson.toJson(new Message(message));

            CreateQueueRequest createQueueRequest = CreateQueueRequest.builder().queueName(queueName).build();
            sqsClient.createQueue(createQueueRequest);

            GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
            String queueUrl = sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl();

            SendMessageRequest sendMsgRequest = SendMessageRequest.builder().queueUrl(queueUrl).messageBody(jsonMessage).delaySeconds(2).build();
            return sqsClient.sendMessage(sendMsgRequest);

        } catch (SqsException e) {
            System.err.println("SQS error: " + e.awsErrorDetails().errorMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String readMessage(String queue){
        try {
            GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queue).build();
            String queueUrl = sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl();
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder().queueUrl(queueUrl).maxNumberOfMessages(1).build();
            ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
            if (!receiveMessageResponse.messages().isEmpty()) {
                Message message = gson.fromJson(receiveMessageResponse.messages().get(0).body(), Message.class);
                DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder().queueUrl(queueUrl).receiptHandle(receiveMessageResponse.messages().get(0).receiptHandle()).build();
                sqsClient.deleteMessage(deleteMessageRequest);
                return message.getContent();
            }
            return null;
        } catch (SqsException e) {
            System.err.println("SQS error: " + e.awsErrorDetails().errorMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String readMessages10Timeout(String queue){
        try {
            GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queue).build();
            String queueUrl = sqsClient.getQueueUrl(getQueueUrlRequest).queueUrl();
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder().queueUrl(queueUrl).
                    maxNumberOfMessages(10). // max 10 messages
                    waitTimeSeconds(20). // long polling
                    build();

            ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(receiveMessageRequest);
            if (!receiveMessageResponse.messages().isEmpty()) {
                System.out.println("Read total messages: " + receiveMessageResponse.messages().size());
                Message message = gson.fromJson(receiveMessageResponse.messages().get(0).body(), Message.class);
                DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder().queueUrl(queueUrl).receiptHandle(receiveMessageResponse.messages().get(0).receiptHandle()).build();
                sqsClient.deleteMessage(deleteMessageRequest);
                return message.getContent();
            }
            return null;
        } catch (SqsException e) {
            System.err.println("SQS error: " + e.awsErrorDetails().errorMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}