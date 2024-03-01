/**
 * Source: https://stackoverflow.com/questions/19510416/credit-card-validator-for-java
 */
public class Main{
  public static void main(String args[]){
    System.out.println("CC 4111111111111111 = " + getCCType("4111111111111111"));
  }

  public static CreditCard getCCType(String ccNumber){
    String visaRegex        = "^4[0-9]{12}(?:[0-9]{3})?$";
    String masterRegex      = "^5[1-5][0-9]{14}$";
    String amexRegex        = "^3[47][0-9]{13}$";
    String dinersClubrRegex = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$";
    String discoverRegex    = "^6(?:011|5[0-9]{2})[0-9]{12}$";
    String jcbRegex         = "^(?:2131|1800|35\\d{3})\\d{11}$";
    String commonRegex      = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    try {
      ccNumber = ccNumber.replaceAll("\\D", "");
      if (ccNumber.matches(visaRegex)){
         return CreditCard.VISA;
      }
      if (ccNumber.matches(masterRegex)){
        return CreditCard.MASTER;
      }
      if (ccNumber.matches(amexRegex)){
        return CreditCard.AMEX;
      }
      if (ccNumber.matches(dinersClubrRegex)){
        return CreditCard.DINER;
      }
      if (ccNumber.matches(discoverRegex)){
        return CreditCard.DISCOVERY;
      }
      if (ccNumber.matches(jcbRegex)){
        return CreditCard.JCB;
      }
      return CreditCard.OTHER;
    } catch (Exception e) {
      throw new IllegalStateException("IDK this CC");
    }
  }
}
