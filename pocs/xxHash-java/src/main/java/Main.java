import net.jpountz.xxhash.XXHash64;
import net.jpountz.xxhash.XXHashFactory;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string to hash: ");
    String input = scanner.nextLine();
    scanner.close();

    String shortHash = generateXXHashShort(input);
    String fullHash = generateXXHashFull(input);
    System.out.println("7-character xxHash: " + shortHash);
    System.out.println("Full xxHash: " + fullHash);
  }

  public static String generateXXHashShort(String input) {
    XXHashFactory factory = XXHashFactory.fastestInstance();
    XXHash64 hasher = factory.hash64();

    byte[] data = input.getBytes(StandardCharsets.UTF_8);
    long hash = hasher.hash(data, 0, data.length, 0);
    String hexHash = Long.toHexString(hash);
    System.out.println("Full xxHash: " + hexHash);

    // Ensure we have at least 7 characters
    while (hexHash.length() < 7) {
      hexHash = "0" + hexHash;
    }
    return hexHash.substring(0, 7);
  }

  public static String generateXXHashFull(String input) {
    XXHashFactory factory = XXHashFactory.fastestInstance();
    XXHash64 hasher = factory.hash64();
    byte[] data = input.getBytes(StandardCharsets.UTF_8);
    long hash = hasher.hash(data, 0, data.length, 0);
    return Long.toHexString(hash);
  }

}