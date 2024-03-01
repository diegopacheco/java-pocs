/**
 * Source: https://stackoverflow.com/questions/19510416/credit-card-validator-for-java
 */
public class Main{
  public static void main(String args[]){
    System.out.println("CC 4111111111111111 = " + getCCType("4111111111111111"));
  }

  public static CreditCard getCCType(String ccNumber){
    String commonRegex      = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    try {
      ccNumber = ccNumber.replaceAll("\\D", "");
      if (ccNumber.matches(CreditCard.VISA.getRegex())){
         return CreditCard.VISA;
      }
      if (ccNumber.matches(CreditCard.MASTER.getRegex())){
        return CreditCard.MASTER;
      }
      if (ccNumber.matches(CreditCard.AMEX.getRegex())){
        return CreditCard.AMEX;
      }
      if (ccNumber.matches(CreditCard.DINER.getRegex())){
        return CreditCard.DINER;
      }
      if (ccNumber.matches(CreditCard.DISCOVERY.getRegex())){
        return CreditCard.DISCOVERY;
      }
      if (ccNumber.matches(CreditCard.JCB.getRegex())){
        return CreditCard.JCB;
      }
      return CreditCard.OTHER;
    } catch (Exception e) {
      throw new IllegalStateException("IDK this CC");
    }
  }
}
