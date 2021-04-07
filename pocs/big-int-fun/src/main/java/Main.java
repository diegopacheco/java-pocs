import com.github.diegopacheco.java.pocs.wrappers.BigInt;

public class Main{
  public static void main(String args[]){
    BigInt b1 = new BigInt("1000");
    BigInt b2 = new BigInt("2000");
    BigInt result = b1.plus(b2);

    System.out.println(b1.toString() + " + " + b2.toString() + " == " + result.toString());
    System.out.println("is possitive? " + result.isPositive());
  }
}
