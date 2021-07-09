import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class Main{
  public static void main(String args[]){
    System.out.println("Commons RNG");

    // Instantiate a "Mersenne-Twister" generator with a factory method.
    UniformRandomProvider rng = RandomSource.create(RandomSource.MT);

    byte[] iv = new byte[16];
    rng.nextBytes(iv);
    System.out.println(iv);

  }
}
