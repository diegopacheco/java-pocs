import com.github.diegopacheco.sandbox.java.props.ThreadLocalProp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{

  private static final String KEY = "Universe";

  public static void main(String args[]){
    ThreadLocalProp tlp = new ThreadLocalProp();
    tlp.set(KEY,"DC");
    System.out.println("Universe is: " + tlp.get(KEY));

    ExecutorService es = Executors.newFixedThreadPool(2);
    submit(es,"MCU","MCU");
    submit(es,"SpiderVerse","SpiderVerse");

  }

  private static void submit(ExecutorService es,String name,String val){
    try{
      es.submit(() -> {
        ThreadLocalProp tlp = new ThreadLocalProp();
        while(true){
          tlp.set(KEY,val);
          System.out.println("[" + name +
                  "] This universe is: " +
                  tlp.get(KEY));
          Thread.sleep(1000L);
        }
      });
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
