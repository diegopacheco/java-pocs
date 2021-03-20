import org.jctools.maps.NonBlockingHashMap;

import java.util.UUID;

public class Main{
  public static void main(String args[]){

    final NonBlockingHashMap nbMap = new NonBlockingHashMap<String, String> ();
    System.out.println(nbMap.get("KA"));
    System.out.println(nbMap.get("KB"));
    System.out.println(nbMap.get("KC"));

    new Thread(() -> {
      while (true){
        nbMap.put("KA", UUID.randomUUID().toString());
        nbMap.put("KB", UUID.randomUUID().toString());
        nbMap.put("KC", UUID.randomUUID().toString());
        silentSleep(1000);
      }
    },"T1").start();

    new Thread(() -> {
      while (true){
        System.out.println(Thread.currentThread().getName() + " - KA: " + nbMap.get("KA"));
        System.out.println(Thread.currentThread().getName() + " - KB: " + nbMap.get("KB"));
        System.out.println(Thread.currentThread().getName() + " - KC: " +  nbMap.get("KC"));
        silentSleep(1000);
      }
    },"T2").start();

  }

  private static void silentSleep(int timeMs){
    try{
      Thread.sleep(timeMs);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
