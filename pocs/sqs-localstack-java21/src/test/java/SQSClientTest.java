import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SQSClientTest {

    @Test
    public void testSendMessage() {
        SQSClient sqsClient = new SQSClient();
        SendMessageResponse res = sqsClient.sendMessage("test-queue", "Hello, world!");
        System.out.println("Message ID: " + res.messageId());
        assertNotNull(res.messageId());
        sqsClient.readMessage("test-queue");
    }

    @Test
    public void testReadMessage() {
        SQSClient sqsClient = new SQSClient();
        sqsClient.sendMessage("test-queue", "Hello, world!");
        String message = sqsClient.readMessage("test-queue");
        System.out.println("Message: " + message);
        assertNotNull(message);
    }

    @Test
    public void write100Read100Test(){
        SQSClient sqsClient = new SQSClient();
        Thread[] threads = new Thread[101];
        for (int i = 0; i < 101; i++) {
            threads[i] = new Thread(() -> {
                sqsClient.sendMessage("test-queue", "Hello, world!");
            });
            threads[i].start();
        }
        for (int i = 0; i < 101; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <100; i++) {
            String message = sqsClient.readMessage("test-queue");
            System.out.println("Message: " + message);
            assertNotNull(message);
        }
    }

    @Test
    public void write100ReadTest(){
        SQSClient sqsClient = new SQSClient();
        Thread[] threads = new Thread[101];
        for (int i = 0; i < 101; i++) {
            threads[i] = new Thread(() -> {
                sqsClient.sendMessage("test-queue", "Hello, world!");
            });
            threads[i].start();
        }
        for (int i = 0; i < 101; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stats: " + sqsClient.getQueueStats("test-queue"));
        for (int i = 0; i <1; i++) {
            String message = sqsClient.readMessage("test-queue");
            System.out.println("Message: " + message);
            assertNotNull(message);
        }
    }

    @Test
    public void write100ReadOnceWithTimeout(){
        SQSClient sqsClient = new SQSClient();
        Thread[] threads = new Thread[101];
        for (int i = 0; i < 101; i++) {
            threads[i] = new Thread(() -> {
                sqsClient.sendMessage("test-queue", "Hello, world!");
            });
            threads[i].start();
        }
        for (int i = 0; i < 101; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String message = sqsClient.readMessages10Timeout("test-queue");
        System.out.println("Message: " + message);
        assertNotNull(message);
    }

}
