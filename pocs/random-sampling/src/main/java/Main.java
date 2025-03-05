import gr.james.sampling.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main{
  public static void main(String args[]){
    WeightedRandomSampling<String> rs = new EfraimidisSampling<>(2, new Random());
    rs.feed("collection", 1);
    rs.feed("algorithms", 2);
    rs.feed("java", 2);
    rs.feed("random", 3);
    rs.feed("sampling", 4);
    rs.feed("reservoir", 5);
    System.out.println(rs.sample());

    RandomSampling<Integer> rs2 = new WatermanSampling<>(10, new Random());
    rs2.feed(IntStream.rangeClosed(1, 100).boxed().iterator());
    Collection<Integer> sample = rs2.sample();
    System.out.println(sample);

    RandomSampling<String> rs3 = new VitterXSampling<>(5, new Random());
    rs3.feed(Arrays.toString(new int[]{1,20,30,45,66,7777,234}));
    System.out.println(rs3.sample());

  }
}
