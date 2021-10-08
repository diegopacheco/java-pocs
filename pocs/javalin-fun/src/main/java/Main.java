import io.javalin.Javalin;

public class Main{
  public static void main(String args[]){
    System.out.println("running on http://localhost:8080/");
    Javalin app = Javalin.create().start(8080);
    app.get("/", ctx -> ctx.result("Hello World"));
  }
}
