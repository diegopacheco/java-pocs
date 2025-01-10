import com.github.diegopacheco.javapocs.driver.v1.contract.FactsContract;
import com.github.diegopacheco.javapocs.driver.v1.impl.FactsImpl;

public class Main{
  public static void main(String args[]){
    FactsContract driver = new FactsImpl();
    driver.getFacts().forEach(System.out::println);
  }
}
