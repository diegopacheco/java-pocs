
public class Main{
  public static void main(String args[]){
    SecretsManagerService sms = new SecretsManagerService();
    String value = sms.getSecret("myKey");
    System.out.println("Secret Key: myKey - Value: " + value);
  }
}
