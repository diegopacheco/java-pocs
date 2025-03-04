import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] stream = new int[1000];
    for (int i = 0; i < stream.length; i++) {
      stream[i] = i + 1;
    }

    int[] sample = moduloSample(stream, 5);
    System.out.println("Selected sample: " + Arrays.toString(sample));
    System.out.println("It works!");
  }

  public static int[] moduloSample(int[] stream, int k) {
    // Calculate approximate sampling interval
    int interval = Math.max(1, stream.length / k);

    int count = (stream.length + interval - 1) / interval;
    int[] result = new int[count];
    int index = 0;
    for (int i = 0; i < stream.length; i++) {
      if (i % interval == 0) {
        result[index++] = stream[i];
      }
    }
    return result;
  }
}