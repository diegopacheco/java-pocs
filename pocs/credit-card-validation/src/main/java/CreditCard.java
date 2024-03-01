public enum CreditCard {
    VISA("VISA","^4[0-9]{12}(?:[0-9]{3})?$"),
    MASTER("MASTER","^5[1-5][0-9]{14}$"),
    AMEX("AMEX", "^3[47][0-9]{13}$"),
    DINER("DINER", "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"),
    DISCOVERY("DISCOVERY", "^6(?:011|5[0-9]{2})[0-9]{12}$"),
    JCB("JCB", "^(?:2131|1800|35\\d{3})\\d{11}$"),
    OTHER("OTHER","");

    private String company;
    private String regex;

    CreditCard(String company,String regex){
        this.company = company;
        this.regex = regex;
    }

    public String getCompany(){
        return company;
    }
    public String getRegex() {
        return regex;
    }

    @Override
    public String toString() {
        return company;
    }

}
