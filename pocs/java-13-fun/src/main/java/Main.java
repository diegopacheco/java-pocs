import java.util.Random;

public class Main{

  public static void main(String args[]){
    formating();
    switchfun();
  }

  private static void formating(){
      String jsonBlock = """
      {
          greeting: "Hello",
          audience: "World",
          punctuation: "!"
      }
      """;
      System.out.println(jsonBlock);
  }

  private static void switchfun(){
    /*
    boolean result = switch (new Random().nextBoolean()){
      case true -> {
          System.out.println("Bool true");
          yield true;
      }
      case false -> {
          System.out.println("Bool false");
          yield false;
      }
    };
    System.out.println(result);
    */
  }

}
