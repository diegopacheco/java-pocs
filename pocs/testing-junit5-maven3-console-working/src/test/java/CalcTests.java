import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTests {

    @Test
    public void testAddition(){
        assertEquals(2+2,4);
    }

    @Test
    public void subtractionTest(){
        assertEquals(2-2,0);
    }

    @Test
    public void division(){
        assertEquals(25/5,5);
    }

    @Test
    public void testMultiplicationTest(){
        assertEquals(5*2,10);
    }

}
