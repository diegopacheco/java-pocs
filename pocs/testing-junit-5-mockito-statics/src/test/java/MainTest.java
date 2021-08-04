import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainTest {

    @Test
    public void testStatic(){
        // Before mocking should be 0
        assertThat(Main.getAnswer()).isEqualTo(0);

        try (MockedStatic<Main> mocked = Mockito.mockStatic(Main.class)) {
            mocked.when(Main::getAnswer).thenReturn(42);
            assertThat(Main.getAnswer()).isEqualTo(42);
        }
    }

}
