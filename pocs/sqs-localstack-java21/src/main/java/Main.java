
public class Main{
  public static void main(String args[]){
    SQSClient sqsClient = new SQSClient();
    sqsClient.sendMessage("test-queue", "Hello, World!");
  }
}
