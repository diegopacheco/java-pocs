public enum CreditCard {
    VISA("VISA"),
    MASTER("MASTER"),
    AMEX("AMEX"),
    DINER("DINER"),
    DISCOVERY("DISCOVERY"),
    JCB("JCB"),
    OTHER("OTHER");

    private String company;

    CreditCard(String company){
        this.company = company;
    }

    public String getCompany(){
        return company;
    }

    @Override
    public String toString() {
        return company;
    }
}
