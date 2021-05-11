import com.github.diegopacheco.java.pocs.caller.NoisyClass;
import com.github.diegopacheco.java.pocs.caller.RightCaller;

public class Main{
  public static void main(String args[]){

    RightCaller rc = new RightCaller();
    rc.printCall();

    NoisyClass nc = new NoisyClass();
    try{
      nc.printCall();
    }catch(Exception e){
      e.printStackTrace();
    }

  }
}
