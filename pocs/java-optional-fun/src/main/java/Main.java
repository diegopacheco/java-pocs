import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /// Option #3 Streams
    System.out.println("Option 3 ");
    IntStream.of(1,2,3,4,5,6,7,8,9,10)
            .map( i-> i * i)
            .filter( n -> n%2==0 )
            .mapToObj( n -> FormatterFactory.getPrinter("upper").get().format("Result: " + n) )
            .forEach(System.out::println);

 }
}
