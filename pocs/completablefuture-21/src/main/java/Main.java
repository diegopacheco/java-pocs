
public class Main{
  public static void main(String args[]){
    MathService mathService = new MathService();
    mathService.sum(1,2).thenAccept(result -> {
      System.out.println("Result: "+result);
    });
    mathService.sub(1,2).thenAccept(result -> {
      System.out.println("Result: "+result);
    });
  }
}
