import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string to hash: ");
    String input = scanner.nextLine();
    scanner.close();

    String fullHash = getFullHash(input);
    String shortHash = getShortHash(input);

    System.out.println("Full hash: " + fullHash);
    System.out.println("Short hash (7 chars): " + shortHash);
  }

  public static String getFullHash(String input) {
    return Hashing.murmur3_128()
            .hashString(input, StandardCharsets.UTF_8)
            .toString();
  }

  public static String getShortHash(String input) {
    String hash = getFullHash(input);
    return hash.length() > 7 ? hash.substring(0, 7) : hash;
  }
}