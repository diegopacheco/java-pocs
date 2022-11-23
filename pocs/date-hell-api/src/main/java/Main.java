import java.util.Calendar;

public class Main {

    static public String getDayOfTheWeek(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0);
        return switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> throw new RuntimeException("IDK this day of the week!");
        };
    }

    public static void main(String args[]) {
        System.out.println("25.12.1988 == " + getDayOfTheWeek(1988, 12,25 ));
    }
}
