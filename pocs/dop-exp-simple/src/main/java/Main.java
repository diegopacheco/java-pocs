import java.util.HashMap;
import java.util.Map;

public class Main{
  public static void main(String args[]){
    withMemory();
    withCPU();
  }

  private static void withMemory(){
    Map<String,String> map = new HashMap<>();
    for (int i=0;i<10000;i++){
      map.put("k"+i,i*i+"");
    }
    Bench.with(new Runnable() {
      @Override
      public void run() {
        int total = 0;
        for (int i=0;i<10000;i++){
          String v = map.get("k"+i);
           if ((i*i+"").equals(v)){
             total++;
          }
        }
        System.out.println("total is " + total);
      }
    },">>> Access 10k elements on map. ");
  }

  private static void withCPU(){
    int count = 0;
    for (int i=0;i<10000;i++){
       if ((i*i+"").equals(i*i+"")){
         count++;
       }
    }
    Bench.with(new Runnable() {
      @Override
      public void run() {
        int total = 0;
        for (int i=0;i<10000;i++){
          if ((i*i+"").equals(i*i+"")){
            total++;
          }
        }
        System.out.println("total is " + total);
      }
    },">>> Access 10k elements on CPU. ");
  }

}
