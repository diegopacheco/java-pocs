import org.junit.jupiter.api.Test;

import java.util.List;

import static com.diffplug.selfie.Selfie.expectSelfie;

public class TestSelfie {

    @Test
    public void simpleTest(){
        // expectSelfie(List.of(1, 2, 3).toString()).toBe_TODO();
        // when you save line 11 becomes line 13.
        expectSelfie(List.of(1, 2, 3).toString()).toBe("[1, 2, 3]");

        // to test the falire comment 13 and uncomment 16.
        //expectSelfie(List.of(42).toString()).toBe("[1, 2, 3]");
    }

    @Test
    public void testDisk(){
        // expectSelfie(List.of(1, 2, 3).toString()).toMatchDisk_TODO();
        // line 21 tuns into 23
        expectSelfie(List.of(1, 2, 3).toString()).toMatchDisk();

        // to break it uncomment 25.
        //expectSelfie(List.of(42).toString()).toMatchDisk();
    }

}
