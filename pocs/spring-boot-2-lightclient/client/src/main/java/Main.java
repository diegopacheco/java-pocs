import com.github.diegopacheco.sandboxspring.client.Client;

import java.util.function.Supplier;

public class Main{

  public static void main(String args[]){
    final Client client = Client.getInstance();
    printTime("Warmup[10x ops]", () -> warmup(client));
    printTime( "2*3==",() -> client.mul(2D,3D));
    printTime( "3+7==",() -> client.sum(3D,7D));
    printTime( "1000-10==",() -> client.sub(100D,10D));
  }

  private static boolean warmup(Client cli){
    try{
      for(int i=0;i<10;i++){
        cli.mul(2D,2D+i);
        cli.sum(2D,2D+i);
        cli.sub(100D,1D+i);
      }
      return true;
    }catch(Exception e){
      return false;
    }
  }

  private static void printTime(String message,Supplier code){
    System.out.print(message);
    long init = System.currentTimeMillis();
    Object result = code.get();
    long end = System.currentTimeMillis();
    System.out.print(result);
    System.out.print( " in " + (end-init) + " ms\n");
  }

}
