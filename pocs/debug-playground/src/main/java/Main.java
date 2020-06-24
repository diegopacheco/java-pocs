import java.io.IOException;

/*
* More on: https://www.baeldung.com/intellij-debugging-tricks
* */
public class Main{

  public static void main(String args[]){
    Pojo p = createPojo1();
    Pojo p2 = createPojo2();
    boolean result = decideAndPrint(p,p2);
    validateAndAbort(result);
  }

  private static Pojo createPojo1(){
    Pojo p = new Pojo();
    p.setName("Diego Pacheco");
    p.setAge(35);
    p.setEmail("diego.pacheco.it@gmail.com");
    return p;
  }

  private static Pojo createPojo2(){
    Pojo p2 = new Pojo();
    p2.setName("Melina");
    p2.setEmail("mel@mel");
    p2.setAge(6);
    return p2;
  }

  private static boolean decideAndPrint(Pojo p,Pojo p2){
    boolean result = p.equals(p2);
    if (result){
      System.out.println(p.getName() + " is same as " + p2.getName());
    }else{
      // (3) Log Break point(Evaluate and log no suspend) "Result is" + result
      System.out.println(p.getName() + " is NOT the same as " + p2.getName());
    }
    print(p,p2);
    return result;
  }

  private static void print(Pojo p,Pojo p2){
    // (1) From here we can Drop Frame 2x.
    System.out.println( "Joining 2 emails: " + String.join(";", p.getEmail(), p2.getEmail()) );
  }

  private static void validateAndAbort(boolean result) {
    if (result){
      throw new RuntimeException(new IOException("Error!"));
    }
  }

}
