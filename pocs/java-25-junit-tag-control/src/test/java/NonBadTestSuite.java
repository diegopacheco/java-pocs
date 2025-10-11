import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.ExcludeTags;

@Suite
@SelectClasses(CalculatorTest.class)
@ExcludeTags("BAD")
public class NonBadTestSuite {
}
