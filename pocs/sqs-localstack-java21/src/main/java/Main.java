
public class Main{
  public static void main(String args[]){
    SQSClient sqsClient = new SQSClient();
    sqsClient.sendMessage("test-queue", "Hello, World!");
    System.out.println(sqsClient.getQueueStats("test-queue"));
    System.out.println(sqsClient.readMessage("test-queue"));
  }
}
