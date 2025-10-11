import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.ExcludeTags;

@Suite
@SelectPackages("")
@ExcludeTags("BAD")
public class NonBadTestSuite {}
