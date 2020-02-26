import static org.quicktheories.generators.Generate.constant;
import static org.quicktheories.generators.Generate.range;

import org.junit.jupiter.api.Test;
import org.quicktheories.WithQuickTheories;

public class SomeTests implements WithQuickTheories {

    @Test
    public void someProperty() {
      qt()
      .forAll(range(1, 102), constant(7))
      .check((i,c) -> i + c >= 7);
    }
  
  }