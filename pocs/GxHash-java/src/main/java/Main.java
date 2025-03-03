import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Enter a string to generate a GxHash:");
    String input = new Scanner(System.in).nextLine();

    String fullHash = generateFullGxHash(input);
    String shortHash = generateShortGxHash(input);

    System.out.println("Original: " + input);
    System.out.println("Full GxHash: " + fullHash);
    System.out.println("Short GxHash (7 chars): " + shortHash);
  }

  public static String generateFullGxHash(String input) {
    if (input == null || input.isEmpty()) {
      return "0";
    }

    // Initial hash value
    long hash = 0x811c9dc5L; // FNV offset basis

    // Prime number for the hash calculation
    final long prime = 0x01000193L; // FNV prime

    // Process each byte in the input
    for (byte b : input.getBytes()) {
      // XOR the current hash with the byte value
      hash ^= (b & 0xff);
      // Multiply by the prime
      hash *= prime;
    }

    // Add some additional bit mixing for better distribution
    hash ^= hash >>> 16;
    hash = (hash * 0x85ebca6bL) & 0xffffffffL;
    hash ^= hash >>> 13;
    hash = (hash * 0xc2b2ae35L) & 0xffffffffL;
    hash ^= hash >>> 16;

    // Convert to hexadecimal string
    return Long.toHexString(hash);
  }

  public static String generateShortGxHash(String input) {
    String fullHash = generateFullGxHash(input);
    if (fullHash.length() <= 7) {
      return fullHash;
    }
    return fullHash.substring(0, 7);
  }
}