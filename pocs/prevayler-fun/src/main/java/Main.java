
public class Main{
  public static void main(String args[]){
    try {
      Service.getInstance().open();
      System.out.println("Prevayler works!");
    } finally {
      Service.getInstance().close();
    }
  }
}
