import java.io.IOException;

public class Main{
  public static void main(String args[]){
    Pojo p = new Pojo();
    p.setName("Diego Pacheco");
    p.setAge(35);
    p.setEmail("diego.pacheco.it@gmail.com");

    Pojo p2 = new Pojo();
    p2.setName("Melina");
    p2.setEmail("mel@mel");
    p2.setAge(6);

    boolean result = p.equals(p2);
    if (result){
      System.out.println(p.getName() + " is same as " + p2.getName());
    }else{
      System.out.println(p.getName() + " is NOT the same as " + p2.getName());
    }

    System.out.println( String.join(";", p.getEmail(), p2.getEmail()) );

    if (result){
      throw new RuntimeException(new IOException("Error!"));
    }

  }
}
