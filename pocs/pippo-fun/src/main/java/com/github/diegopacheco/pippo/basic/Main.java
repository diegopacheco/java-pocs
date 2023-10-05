import ro.pippo.core.Pippo;

public class Main{
  public static void main(String args[]){
    Pippo pippo = new Pippo(new BasicApplication());
    pippo.getServer().setPort(8080);
    System.out.println("Pippo Server running on http://127.0.0.1:8080/");
    pippo.start();
  }
}
