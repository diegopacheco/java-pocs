import com.github.diegopacheco.fp.Monoids;
import com.github.diegopacheco.fp.PureFunctions;
import com.github.diegopacheco.fp.Fold;
import com.github.diegopacheco.fp.Curry;
import com.github.diegopacheco.fp.Monads;
import com.github.diegopacheco.fp.Immutability;
import com.github.diegopacheco.fp.HighOrderFunctions;

public class Main{
  public static void main(String[] args){
    System.out.println("*** Pure Functions");
    System.out.println(" 4242424242424242 is valid? " + new PureFunctions().validateCreditCard("4242424242424242"));

    System.out.println("*** Foldable ");
    System.out.println(" Sum all 1 to 5 = " + new Fold().sumAll());

    System.out.println("*** Monoids ");
    System.out.println(" Sum all 1 to 5 = " + new Monoids().sumAll());

    System.out.println("*** Curry / Partial Application");
    System.out.println(" Sum 5 + 1 and then * 2 + 2+3 = " + new Curry().sum() );

    System.out.println("*** Monads ");
    System.out.println(" Result = " + new Monads().result());

    System.out.println("*** Immutability ");
    System.out.println(" Result = " + new Immutability().result());

    System.out.println("*** High Order Functions ");
    System.out.println(" 6! = " + new HighOrderFunctions().factorial6());
  }
}
