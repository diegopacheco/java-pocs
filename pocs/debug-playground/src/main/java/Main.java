import java.io.IOException;

public class Main{
  public static void main(String args[]){
    Pojo p = new Pojo();
    p.setName("Diego Pacheco");
    p.setAge(35);
    p.setEmail("diego.pacheco.it@gmail.com");

    Pojo p2 = new Pojo();
    p.setName("Melina");
    p.setEmail("mel@mel");
    p.setAge(6);

    boolean result = p.equals(p2);
    if (result){
      System.out.println(p.getName() + " is same as " + p2.getName());
    }else{
      System.out.println(p.getName() + " is NOT the same as " + p2.getName());
    }

    if (result){
      throw new RuntimeException(new IOException("Error!"));
    }

  }
}
