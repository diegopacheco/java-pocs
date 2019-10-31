import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class GenerateTests {

    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
          DynamicTest.dynamicTest("Add test",
            () -> assertEquals(2, Math.addExact(1, 1))),
          DynamicTest.dynamicTest("Multiply Test",
            () -> assertEquals(4, Math.multiplyExact(2, 2))));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {        
        List<String> inputList = Arrays.asList(
        "www.somedomain.com", "www.anotherdomain.com", "www.yetanotherdomain.com",
        "github.com", "ilegra.com");
            
        return inputList.stream()
        .map(dom -> DynamicTest.dynamicTest("Resolving: " + dom, 
            () -> { int id = inputList.indexOf(dom);
            assertNotNull(id);
        }));       
    }

}