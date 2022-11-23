import java.math.BigDecimal;

public class Main {
    public static void main(String args[]) {
        BigDecimal b1 = new BigDecimal("1000");
        BigDecimal b2 = new BigDecimal("1.3");
        BigDecimal result = b1.multiply(b2);
        System.out.println("30% == " + result);
    }
}
