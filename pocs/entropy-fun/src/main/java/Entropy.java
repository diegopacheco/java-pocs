
/**
 * Demonstrates how to calculate the entropy of a file, or basically a measure
 * of file randomness. This can be useful when determining how "compressible"
 * something is, although it is worth noting that it is just an estimate. Some
 * algorithms may not be able to reach optimal reduction in size, while
 * domain-specific compression may be able to do even better. Caveat emptor.
 */
public class Entropy {

    public static double entropy(byte[] input) {
        if (input.length == 0) {
            return 0.0;
        }

        /* Total up the occurrences of each byte */
        int[] charCounts = new int[256];
        for (byte b : input) {
            charCounts[b & 0xFF]++;
        }

        double entropy = 0.0;
        for (int i = 0; i < 256; ++i) {
            if (charCounts[i] == 0.0) {
                continue;
            }

            double freq = (double) charCounts[i] / input.length;
            entropy -= freq * (Math.log(freq) / Math.log(2));
        }
        return entropy;
    }

}