
import xerial.larray.japi.LArrayJ;
import xerial.larray.*;

public class Main{
  public static void main(String args[]){

    LIntArray l = LArrayJ.newLIntArray(10000L);
    l.update(0L, 20); // Set l[0L] = 20
    int e0 = l.apply(0L);  //  Get l[0L]
    // release
    l.free();
    System.out.println(e0);
  }
}
