import com.github.diegopacheco.bookkeeping.bookkeeping.Entry;
import com.github.diegopacheco.bookkeeping.bookkeeping.UserLog;
import com.github.diegopacheco.bookkeeping.events.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.UUID;

public class Main {
    public static void main(String args[]) {

        UserLog userLog = new UserLog();
        UUID idUser1 = UUID.randomUUID();
        UUID idUser2 = UUID.randomUUID();
        UUID idUser3 = UUID.randomUUID();
        UUID idUser4 = UUID.randomUUID();

        userLog.log(idUser1, SignUpEvent.builder()
                .withUserId(idUser1)
                .withEventDescription("User 1, signed up in the hotel website")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now())
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 1, occur, charges 100$")
                .build());

        userLog.log(idUser1, RoomBookedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now())
                .withRoom("M-1001")
                .withTotal(BigDecimal.valueOf(10000.0))
                .withEventDescription("User 1, book a master suite for 10 nights")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now())
                .withService("Food/Drinks")
                .withTotal(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, night 1, order a bottle of wine")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now())
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 2, occur, charges 100$")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(2, ChronoUnit.DAYS))
                .withService("Food/Drinks")
                .withTotal(BigDecimal.valueOf(358.25))
                .withEventDescription("User 1, night 2, order caviar")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(3, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 3, occur, charges 100$")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(3, ChronoUnit.DAYS))
                .withService("Food/Drinks")
                .withTotal(BigDecimal.valueOf(12.00))
                .withEventDescription("User 1, night 3, order french fries")
                .build());

        userLog.log(idUser2, SignUpEvent.builder()
                .withUserId(idUser2)
                .withEventDescription("User 2, signed up in the hotel website")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(4, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 4, occur, charges 100$")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(4, ChronoUnit.DAYS))
                .withService("WakeUpCall")
                .withTotal(BigDecimal.valueOf(358.25))
                .withEventDescription("User 1, day 4, schedule a wake up call 8:00 for night 10")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(5, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 5, occur, charges 100$")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(5, ChronoUnit.DAYS))
                .withService("LateCheckOut")
                .withTotal(BigDecimal.valueOf(150.00))
                .withEventDescription("User 1, day 5, ask for a late check out")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(6, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 6, occur, charges 100$")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(7, ChronoUnit.DAYS))
                .withService("ExtraTowels")
                .withTotal(BigDecimal.valueOf(15.00))
                .withEventDescription("User 1, day 7, order extra towels")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(7, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 7, occur, charges 100$")
                .build());

        userLog.log(idUser3, SignUpEvent.builder()
                .withUserId(idUser3)
                .withEventDescription("User 3, signed up in the hotel website")
                .build());

        userLog.log(idUser1, RoomServiceOrderedEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(7, ChronoUnit.DAYS))
                .withService("ExtendReservation")
                .withTotal(BigDecimal.valueOf(300.00))
                .withEventDescription("User 1, day 7, extend the stay for 3 more days")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(8, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 8, occur, charges 100$")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(9, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 9, occur, charges 100$")
                .build());

        userLog.log(idUser1, DailyFeeEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(10, ChronoUnit.DAYS))
                .withValue(BigDecimal.valueOf(100.0))
                .withEventDescription("User 1, system, day 10, occur, charges 100$")
                .build());

        userLog.log(idUser1, CheckedOutEvent.builder()
                .withUserId(idUser1)
                .withTimestamp(Instant.now().plus(10, ChronoUnit.DAYS))
                .withTotal(BigDecimal.valueOf(1000.0))
                .withEventDescription("User 1, checkout 10 PM, total 1000$").build());

        userLog.log(idUser4, SignUpEvent.builder()
                .withUserId(idUser4)
                .withEventDescription("User 4, signed up in the hotel website")
                .build());

        LinkedHashSet<Entry> entries = userLog.getEntriesByID(idUser1);
        for (Entry entry : entries) {
            System.out.println(entry.getEvent());
        }
    }
}
