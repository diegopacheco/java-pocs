import java.util.Scanner;
import java.util.Random;

public class Main {
  // Base62 character set (0-9, a-z, A-Z)
  private static final String BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final int HASH_LENGTH = 7;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter text to hash: ");
    String input = scanner.nextLine();
    scanner.close();

    String hash = generateBase62Hash(input);
    System.out.println("Generated 7-character base62 hash: " + hash);
  }

  public static String generateBase62Hash(String input) {
    if (input == null || input.isEmpty()) {
      return getRandomBase62Hash();
    }

    StringBuilder result = new StringBuilder(HASH_LENGTH);

    // Use a more consistent hashing approach
    int hash = input.hashCode();
    // Convert to unsigned value to avoid negative numbers
    long unsignedHash = hash & 0xffffffffL;

    // Generate 7 characters using base62
    for (int i = 0; i < HASH_LENGTH; i++) {
      int index = (int) (unsignedHash % 62);
      result.append(BASE62_CHARS.charAt(index));
      unsignedHash = unsignedHash / 62;
    }

    return result.toString();
  }

  private static String getRandomBase62Hash() {
    // Fallback to random hash if input is empty
    StringBuilder result = new StringBuilder(HASH_LENGTH);
    Random random = new Random();
    for (int i = 0; i < HASH_LENGTH; i++) {
      int index = random.nextInt(BASE62_CHARS.length());
      result.append(BASE62_CHARS.charAt(index));
    }
    return result.toString();
  }
}