import java.util.List;

import static net.andreinc.mockneat.types.enums.CreditCardType.AMERICAN_EXPRESS;
import static net.andreinc.mockneat.types.enums.CreditCardType.VISA_16;
import static net.andreinc.mockneat.types.enums.DomainSuffixType.POPULAR;
import static net.andreinc.mockneat.types.enums.IPv4Type.CLASS_B;
import static net.andreinc.mockneat.types.enums.IPv4Type.CLASS_C_NONPRIVATE;
import static net.andreinc.mockneat.unit.financial.CreditCards.creditCards;
import static net.andreinc.mockneat.unit.networking.IPv4s.ipv4s;
import static net.andreinc.mockneat.unit.networking.URLs.urls;
import static net.andreinc.mockneat.unit.seq.Seq.seq;
import static net.andreinc.mockneat.unit.text.CSVs.csvs;
import static net.andreinc.mockneat.unit.text.Formatter.fmt;
import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;

public class Main{
  public static void main(String args[]){
    List<String> somePeople = names().full().list(10).get();
    fmt("#{person} rolled: #{roll1} #{roll2}")
            .param("person", seq(somePeople))
            .param("roll1", ints().rangeClosed(1, 6))
            .param("roll2", ints().rangeClosed(1, 6))
            .accumulate(10, "\n")
            .consume(System.out::println);
    System.out.println("\nWho wins ?\n");

    System.out.println("First Name, Last Name, Email, Site, IP, Credit Card, Date");
    csvs()
            .column(names().first())
            .column(names().last())
            .column(emails().domain("mockneat.com"))
            .column(urls().domains(POPULAR))
            .column(ipv4s().types(CLASS_B, CLASS_C_NONPRIVATE))
            .column(creditCards().types(AMERICAN_EXPRESS, VISA_16))
            .column(localDates().thisYear())
            .separator(" ; ")
            .accumulate(25, "\n")
            .consume(System.out::println);

  }
}
