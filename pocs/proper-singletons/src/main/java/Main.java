
public class Main{
  public static void main(String args[]){
      ProperSingleton singleton = ProperSingleton.getInstance();
      System.out.println(singleton);
      System.out.println(ProperSingleton.getInstance());
  }
}
