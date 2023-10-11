import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main{
  public static void main(String args[]){

    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    for (int i: IntStream.range(0,numbers.size()).toArray()){
      System.out.println(i);
    }

  }
}
