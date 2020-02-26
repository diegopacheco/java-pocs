import org.junit.jupiter.api.Test;

import io.vavr.test.Arbitrary;
import io.vavr.test.Property;

public class PropertyBasedTesting{
    
    @Test
    public void testProps(){
        Arbitrary<Integer> ints = Arbitrary.integer();

        // square(int) >= 0: OK, passed 1000 tests.
        Property.def("square(int) >= 0")
                .forAll(ints)
                .suchThat(i -> i * i >= 0)
                .check()
                .assertIsSatisfied();
    }
}