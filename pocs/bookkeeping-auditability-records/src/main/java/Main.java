import com.github.diegopacheco.bookkeeping.bookkeeping.Entry;
import com.github.diegopacheco.bookkeeping.bookkeeping.UserLog;
import com.github.diegopacheco.bookkeeping.events.SignUpEvent;

import java.util.LinkedHashSet;
import java.util.UUID;

public class Main {
    public static void main(String args[]) {

        UserLog userLog = new UserLog();
        UUID idUser1 = UUID.randomUUID();

        userLog.log(idUser1, SignUpEvent.builder()
                .withUserId(idUser1)
                .withEventDescription("User 1, signed up in the hotel website")
                .build());

        userLog.log(idUser1, "User 1, system, day 1, occur, charges 100$");
        userLog.log(idUser1, "User 1, book a master suite for 10 nights");
        userLog.log(idUser1, "User 1, night 1, order a bottle of wine");
        userLog.log(idUser1, "User 1, system, day 2, occur, charges 100$");
        userLog.log(idUser1, "User 1, night 2, order caviar");
        userLog.log(idUser1, "User 1, system, day 3, occur, charges 100$");
        userLog.log(idUser1, "User 1, night 3, ask for room service");
        userLog.log("User 2, signed up in the hotel website");
        userLog.log(idUser1, "User 1, system, day 4, occur, charges 100$");
        userLog.log(idUser1, "User 1, day 4, schedule a wake up call 8:00 for night 10");
        userLog.log(idUser1, "User 1, system, day 5, occur, charges 100$");
        userLog.log(idUser1, "User 1, day 5, ask for a late check out");
        userLog.log(idUser1, "User 1, system, day 6, occur, charges 100$");
        userLog.log(idUser1, "User 1, day 6, order extra towels");
        userLog.log(idUser1, "User 1, system, day 7, occur, charges 100$");
        userLog.log(idUser1, "User 1, day 7, order extra towels");
        userLog.log("User 3, signed up in the hotel website");
        userLog.log(idUser1, "User 1, day 7, extend the stay for 3 more days");
        userLog.log(idUser1, "User 1, system, day 8, occur, charges 100$");
        userLog.log(idUser1, "User 1, system, day 9, occur, charges 100$");
        userLog.log(idUser1, "User 1, system, day 10, occur, charges 100$");
        userLog.log(idUser1, "User 1, checkout 10 PM, total 1000$");
        userLog.log("User 4, signed up in the hotel website");

        LinkedHashSet<Entry> entries = userLog.getEntriesByID(idUser1);
        for (Entry entry : entries) {
            System.out.println(entry.getEvent());
        }
    }
}
