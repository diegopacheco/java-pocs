import org.cactoos.func.Async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main{
  public static void main(String args[]) throws ExecutionException, InterruptedException {
    Async<Integer, Integer> asyncFunction = new Async<Integer, Integer>(Main::factorial);
    Future<Integer> asyncFuture = asyncFunction.apply(6);
    int result = asyncFuture.get();
    System.out.println(result);
  }

  private static int factorial(Integer input) {
    int i,fact=1;
    for(i=1;i<=input;i++){
      fact=fact*i;
    }
    return fact;
  }
}
