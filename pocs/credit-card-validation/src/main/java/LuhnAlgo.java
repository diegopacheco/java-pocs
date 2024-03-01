/**
 * Source: https://stackoverflow.com/questions/19510416/credit-card-validator-for-java
 */
public class LuhnAlgo {
    public static void main(String[] args) {
        System.out.println("4111111111111111 is valid ? == " + isValidCardNumber("4111111111111111"));
    }
    public static boolean isValidCardNumber(String ccNumber) {
        try {
            ccNumber = ccNumber.replaceAll("\\D", "");
            char[] ccNumberArry = ccNumber.toCharArray();

            int checkSum = 0;
            for (int i = ccNumberArry.length - 1; i >= 0; i--) {
                char ccDigit = ccNumberArry[i];
                if ((ccNumberArry.length - i) % 2 == 0) {
                    int doubleddDigit = Character.getNumericValue(ccDigit) * 2;
                    checkSum += (doubleddDigit % 9 == 0 && doubleddDigit != 0) ? 9 : doubleddDigit % 9;
                } else {
                    checkSum += Character.getNumericValue(ccDigit);
                }
            }
            return (checkSum != 0 && checkSum % 10 == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
