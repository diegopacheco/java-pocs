/**
 * Source: https://stackoverflow.com/questions/19510416/credit-card-validator-for-java
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("CC 4111111111111111 = " + getCCType("4111111111111111"));
    }

    public static CreditCard getCCType(String ccNumber) {
        return CreditCard.discover(ccNumber).get();
    }
}