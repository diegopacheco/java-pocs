import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class StringProperties {

    @Property @Test
    public void concatenationLengthTest(String s1, String s2) {
        assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }

}