import org.apache.logging.log4j.core.util.CronExpression;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CronTest {
    @Test
    public void testCronExpression() throws ParseException {
        CronExpression cron = new CronExpression("0 0 0 * * ?");
        cron.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        ZonedDateTime date = LocalDateTime.of(2020, 6, 1, 9, 52, 0).atZone(ZoneId.of("Europe/London"));
        ZonedDateTime expected = LocalDateTime.of(2020, 6, 2, 0, 0, 0).atZone(ZoneId.of("Europe/London"));
        assertThat(cron.getNextValidTimeAfter(Date.from(date.toInstant())), is(Date.from(expected.toInstant())));
    }
}