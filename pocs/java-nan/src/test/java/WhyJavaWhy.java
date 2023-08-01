import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WhyJavaWhy {

    @Test
    public void testInteger(){
        assertThrows(ArithmeticException.class, ()->{
                System.out.println(1/0);
        });
    }

    @Test
    public void testInfinity(){
        String expected = "Infinity";
        String resul = (1.0/0.0)+"";
        System.out.println(resul);
        assertEquals(expected,resul);
    }

    @Test
    public void testNaN2(){
        String expected = "NaN";
        String resul = (0d/0)+"";
        System.out.println(resul);
        assertEquals(expected,resul);
    }

}
