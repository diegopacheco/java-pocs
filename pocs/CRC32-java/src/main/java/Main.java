import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.zip.CRC32;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string to hash: ");
    String input = scanner.nextLine();
    scanner.close();

    System.out.println("Short hash (7 bytes): " + shortHash(input));
    System.out.println("Full hash: " + fullHash(input));
  }

  public static String fullHash(String input) {
    CRC32 crc = new CRC32();
    crc.update(input.getBytes(StandardCharsets.UTF_8));
    return Long.toHexString(crc.getValue());
  }

  public static String shortHash(String input) {
    CRC32 crc = new CRC32();
    crc.update(input.getBytes(StandardCharsets.UTF_8));
    String fullHashHex = Long.toHexString(crc.getValue());

    while (fullHashHex.length() < 7) {
      fullHashHex = "0" + fullHashHex;
    }
    return fullHashHex.substring(0, 7);
  }

}