import net.openhft.hashing.LongHashFunction;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string to hash: ");
    String input = scanner.nextLine();
    scanner.close();

    String fullHash = generateFullHash(input);
    String shortHash = generateShortHash(input);

    System.out.println("Input string: " + input);
    System.out.println("Full hash: " + fullHash);
    System.out.println("Short hash (7 chars): " + shortHash);
  }

  public static String generateFullHash(String input) {
    long hash = LongHashFunction.wy_3().hashChars(input);
    return Long.toHexString(hash);
  }

  public static String generateShortHash(String input) {
    String fullHash = generateFullHash(input);
    return fullHash.substring(0, Math.min(7, fullHash.length()));
  }
}