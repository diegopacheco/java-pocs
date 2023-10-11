import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) {
        approachOne();
        approachTwo();
        approachThree();
    }

    private static void approachOne() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i : IntStream.range(0, numbers.size()).toArray()) {
            System.out.print(i);
        }
        System.out.println("");
    }

    private static void approachTwo() {
        IntStream.range(0, 10).forEachOrdered(n -> {
            System.out.print(n);
        });
        System.out.println("");
    }

    private static void approachThree(){
      for(int i: Range.of(10)){
        System.out.print(i);
      }
      System.out.println("");
    }

}
