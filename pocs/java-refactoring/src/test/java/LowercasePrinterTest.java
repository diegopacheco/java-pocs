import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LowercasePrinterTest {

    @Test
    public void testLowercasePrint(){
        Formatter f = new LowercaseFormatter();
        Assertions.assertEquals("works?",f.format("works?"));
    }

    @Test
    public void testLowercasePrintWithNull(){
        Formatter f = new LowercaseFormatter();
        Assertions.assertEquals("",f.format(null));
    }

}
