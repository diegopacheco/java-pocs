import java.util.function.Consumer;

public class Main{

  public static void main(String args[]){
    bench( (Void)-> { insertData(); });
    bench( (Void)-> { count(); });
  }

  private static void insertData(){

  }

  private static void count(){

  }

  private static void bench(Consumer<Void> func){
    long init = System.currentTimeMillis();
    func.accept(null);
    long end = System.currentTimeMillis();
    System.out.println("Executed in > " + (end-init) + " ms.");
  }

}
