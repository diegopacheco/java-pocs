import com.github.diegopacheco.javapocs.pitest.service.CalculatorService;

public class Main{
  public static void main(String args[]){
    CalculatorService calc = new CalculatorService();
    System.out.println("2 * 3 = " + calc.mul(2D,3D));
  }
}
