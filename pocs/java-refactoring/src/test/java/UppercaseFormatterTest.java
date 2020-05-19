import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UppercaseFormatterTest {

    @Test
    public void testUppercasePrint(){
        Formatter f = new UppercaseFormatter();
        Assertions.assertEquals("WORKS?",f.format("works?"));
    }

    @Test
    public void testUppercasePrintWithNull(){
        Formatter f = new UppercaseFormatter();
        Assertions.assertEquals("",f.format(null));
    }


}
