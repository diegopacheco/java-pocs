import java.util.Optional;

public enum CreditCard {
    VISA("VISA","^4[0-9]{12}(?:[0-9]{3})?$"),
    MASTER("MASTER","^5[1-5][0-9]{14}$"),
    AMEX("AMEX", "^3[47][0-9]{13}$"),
    DINER("DINER", "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"),
    DISCOVERY("DISCOVERY", "^6(?:011|5[0-9]{2})[0-9]{12}$"),
    JCB("JCB", "^(?:2131|1800|35\\d{3})\\d{11}$"),
    OTHER("OTHER","");

    private String company;
    private String number;
    private String regex;

    CreditCard(String company,String regex){
        this.company = company;
        this.regex = regex;
    }

    public static Optional<CreditCard> discover(String ccNumber){
        try {
            CreditCard cc = CreditCard.OTHER;
            cc.number = ccNumber;
            ccNumber = ccNumber.replaceAll("\\D", "");
            if (ccNumber.matches(CreditCard.VISA.regex)){
                cc.company = CreditCard.VISA.company;
                return Optional.of(cc);
            }
            if (ccNumber.matches(CreditCard.MASTER.regex)){
                cc.company = CreditCard.MASTER.company;
                return Optional.of(cc);
            }
            if (ccNumber.matches(CreditCard.AMEX.regex)){
                cc.company = CreditCard.AMEX.company;
                return Optional.of(cc);
            }
            if (ccNumber.matches(CreditCard.DINER.regex)){
                cc.company = CreditCard.DINER.company;
                return Optional.of(cc);
            }
            if (ccNumber.matches(CreditCard.DISCOVERY.regex)){
                cc.company = CreditCard.DISCOVERY.company;
                return Optional.of(cc);
            }
            if (ccNumber.matches(CreditCard.JCB.regex)){
                cc.company = CreditCard.JCB.company;
                return Optional.of(cc);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException("IDK this CC");
        }
    }

    public String getCompany(){
        return company;
    }
    public String getRegex() {
        return regex;
    }
    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return company;
    }

}
