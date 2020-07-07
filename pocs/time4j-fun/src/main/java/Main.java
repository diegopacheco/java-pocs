import net.time4j.*;
import net.time4j.format.TextWidth;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.format.expert.PatternType;
import net.time4j.history.ChronoHistory;
import net.time4j.tz.olson.ASIA;
import net.time4j.tz.olson.EUROPE;
import java.time.LocalDate;
import java.util.Locale;

import static net.time4j.CalendarUnit.MONTHS;
import static net.time4j.PlainDate.DAY_OF_MONTH;
import static net.time4j.PlainDate.DAY_OF_WEEK;
import static net.time4j.PlainTime.MINUTE_OF_HOUR;
import static net.time4j.Weekday.WEDNESDAY;

public class Main{
  public static void main(String args[]){
    // What is the last day of overnext month?
    System.out.println(
            SystemClock.inLocalView().today().plus(2, MONTHS).with(DAY_OF_MONTH.maximized()));

    // When is next wednesday?
    PlainDate today = SystemClock.inLocalView().today();
    PlainDate nextWednesday = today.with(DAY_OF_WEEK.setToNext(WEDNESDAY));
    System.out.println(nextWednesday);

    // What is the current wall time rounded down to multiples of 5 minutes?
    PlainTimestamp currentLocalTimestamp = SystemClock.inZonalView(EUROPE.BERLIN).now();
    PlainTime roundedTime =
            currentLocalTimestamp.getWallTime() // T22:06:52,688
                    .with(MINUTE_OF_HOUR.atFloor()) // T22:06
                    .with(MINUTE_OF_HOUR.roundedDown(5)); // T22:05
    System.out.println("Rounded wall time: " + roundedTime);

    // Example for flexible dayperiods
    PlainTime eveningTime = PlainTime.of(20, 45);
    ChronoFormatter<PlainTime> formatter =
            ChronoFormatter.ofTimePattern("h:mm B", PatternType.CLDR, Locale.ENGLISH);
    System.out.println(
            "12-hour-format with dayperiod: "
                    + formatter.format(eveningTime)); // 8:45 in the evening

    // How does last UTC-leapsecond look like in Japan?
    Moment leapsecondUTC =
            PlainDate.of(2012, Month.JUNE, 30)
                    .at(PlainTime.midnightAtEndOfDay()) // 2012-06-30T24 => 2012-07-01T00
                    .atUTC().minus(1, SI.SECONDS);
    System.out.println(leapsecondUTC); // 2012-06-30T23:59:60Z

    System.out.println(
            "Japan-Time: "
                    + ChronoFormatter.ofMomentPattern(
                    "uuuu-MM-dd'T'HH:mm:ssXX",
                    PatternType.CLDR,
                    Locale.ROOT,
                    ASIA.TOKYO
            ).format(leapsecondUTC)
    ); // Japan-Time: 2012-07-01T08:59:60+0900

    // duration in seconds normalized to hours, minutes and seconds
    Duration<ClockUnit> dur = Duration.of(337540, ClockUnit.SECONDS).with(Duration.STD_CLOCK_PERIOD);

    // custom duration format => hh:mm:ss
    String s1 = Duration.Formatter.ofPattern(ClockUnit.class, "hh:mm:ss").format(dur);
    System.out.println(s1); // output: 93:45:40

    // localized duration format for french
    String s2 = PrettyTime.of(Locale.FRANCE).print(dur, TextWidth.WIDE);
    System.out.println(s2); // output: 93 heures, 45 minutes et 40 secondes

    // following code requires v4.20 (or later) and Java-8 using java.time.LocalDate
    ChronoFormatter<LocalDate> formatter2 =
            ChronoFormatter.setUp(PlainDate.threeten(), new Locale("en", "SE"))
                    .addPattern("GGGG yyyy, MMMM ", PatternType.CLDR)
                    .addEnglishOrdinal(ChronoHistory.ofSweden().dayOfMonth())
                    .build();
    System.out.println(formatter2.format(LocalDate.of(1712, 3, 11)));
    // output: Anno Domini 1712, February 30th
  }
}
