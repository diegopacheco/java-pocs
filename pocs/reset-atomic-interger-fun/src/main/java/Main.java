import com.github.diegopacheco.counter.InfiniteCounter;

public class Main{
  public static void main(String args[]){
    InfiniteCounter ic = InfiniteCounter.getInstance();
    while (true){
        int counter = ic.inc();
        if (counter % 100000000 == 0 && counter > 0) {
          System.out.println(counter);
        }
    }
  }
}
