import com.github.diegopacheco.sandboxspring.client.Client;

public class Main{
  public static void main(String args[]){
    Client client = Client.getInstance();
    System.out.println("client: " + client);
    System.out.println("2*3==" + client.mul(2D,3D));
    System.out.println("3+7==" + client.sum(3D,7D));
    System.out.println("1000-10==" + client.sub(100D,10D));
  }
}
