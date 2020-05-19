import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class FormatterBuilderTest {

    @Test
    public void invalidFormatter(){
        Optional<Formatter> f = FormatterBuilder.build("sbrubles");
        Assertions.assertEquals(FormatterBuilder.EMPTY,f.get());
    }

    @Test
    public void upperCaseTest(){
        Optional<Formatter> f = FormatterBuilder.build("up");
        Assertions.assertNotEquals(Optional.empty(),f);
        Assertions.assertEquals("UPPER?",f.get().format("UPPER?"));
    }

    @Test
    public void lowerCaseTest(){
        Optional<Formatter> f = FormatterBuilder.build("down");
        Assertions.assertNotEquals(Optional.empty(),f);
        Assertions.assertEquals("down?",f.get().format("DOWN?"));
    }

}
