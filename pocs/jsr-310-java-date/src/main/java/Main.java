import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String dateString = "2023-10-01 12:00:00";
    LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
    ZoneId zoneId = ZoneId.of("America/New_York");

    ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
    System.out.println("Original date: " + zonedDateTime);

    ZonedDateTime newZonedDateTime = zonedDateTime.plusDays(1);
    System.out.println("New date: " + newZonedDateTime);
  }
}