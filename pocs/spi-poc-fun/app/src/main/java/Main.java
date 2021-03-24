import com.github.diegopacheco.java.pocs.api.ExchangeRate;
import com.github.diegopacheco.java.pocs.api.Quote;

import java.time.LocalDate;
import java.util.List;

public class Main{
  public static void main(String args[]){
    System.out.println("Running... ");

    ExchangeRate.providers().forEach(provider -> {
      System.out.println("Retreiving USD quotes from provider :" + provider);
      List<Quote> quotes = provider.create().getQuotes("USD", LocalDate.now());
      System.out.println(String.format("%14s%12s|%12s", "","Ask", "Bid"));
      System.out.println("----------------------------------------");
      quotes.forEach(quote -> {
        System.out.println("USD --> " + quote.getCurrency() + " : " + String.format("%12f|%12f", quote.getAsk(), quote.getBid()));
      });
    });
    
    System.out.println("DONE.");
  }
}
