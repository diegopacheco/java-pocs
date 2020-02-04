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
    
    boolean result = switch (new Random().nextInt() % 1){
      case 0 -> {
          System.out.println("Bool true");
          yield true;
      }
      case 1 -> {
          System.out.println("Bool false");
          yield false;
      }
      default -> {
          System.out.println("DEFAULT");
          yield false;
      }
    };
    System.out.println(result);
    
  }

}
