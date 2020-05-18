import java.util.Optional;

public class Main{
  public static void main(String args[]){

    /// Option # 1 ifPresent
    Optional<Formatter> printer = FormatterFactory.getPrinter("lower");
    if (printer.isPresent()){
      String message = printer.get().format("IT WORKS");
      System.out.println("MSG From formatter: " + message);
    }else{
      System.out.println("No Formatter");
    }

    /// Option # 2 ofElseGet
    System.out.println("Option 2 = " + printer.
            orElseGet( () -> new EmptyFormatter()).format("ok"));

    System.out.println("Option 2 = " +
            FormatterFactory.getPrinter("???").
                    orElseGet( () -> new EmptyFormatter()).
                    format("ok"));

  }
}
