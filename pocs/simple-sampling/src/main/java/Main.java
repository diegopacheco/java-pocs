import java.util.Random;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] stream = new int[1000];
    for (int i = 0; i < stream.length; i++) {
      stream[i] = i + 1;
    }

    int[] sample = reservoirSample(stream, 5);
    System.out.println("Selected sample: " + Arrays.toString(sample));
    System.out.println("It works!");
  }

  public static int[] reservoirSample(int[] stream, int k) {
    int[] reservoir = new int[k];
    Random random = new Random();
    // Fill the reservoir with the first k elements
    for (int i = 0; i < k && i < stream.length; i++) {
      reservoir[i] = stream[i];
    }
    for (int i = k; i < stream.length; i++) {
      int j = random.nextInt(i + 1);
      if (j < k) {
        reservoir[j] = stream[i];
      }
    }
    return reservoir;
  }
}