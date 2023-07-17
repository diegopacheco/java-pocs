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
      map.put("k"+i,"v"+i);
    }
    Bench.with(new Runnable() {
      @Override
      public void run() {
        int total = 0;
        for (int i=0;i<10000;i++){
          String v = map.get("k"+i);
           if (("v"+i).equals(v)){
             total++;
          }
        }
        System.out.println("total is " + total);
      }
    },">>> Access 10k elements on map. ");
  }

  private static void withCPU(){
    Map<String,String> map = new HashMap<>();
    String key = "C";
    String value = "T";
    for (int i=0;i<10000;i++){
       if ((key+i).equals(value+i)){
         i=0;
       }
    }
    Bench.with(new Runnable() {
      @Override
      public void run() {
        int total = 0;
        for (int i=0;i<10000;i++){
          String v = key+i;
          if ((value+i).equals(v)){
            total++;
          }
        }
        System.out.println("total is " + total);
      }
    },">>> Access 10k elements on CPU. ");
  }

}
