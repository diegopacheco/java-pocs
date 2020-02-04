import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Double toBeTruncated = new Double("3.5789055");

        Double truncatedDouble = BigDecimal.
                                    valueOf(toBeTruncated).
                                    setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println("original: " + toBeTruncated);
        System.out.println("trucated: " + truncatedDouble);
    }
}