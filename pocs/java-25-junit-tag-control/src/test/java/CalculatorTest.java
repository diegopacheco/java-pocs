import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

  private final Calculator calculator = new Calculator();

  @Test
  @Tag("BAD")
  public void testAddition() {
    assertEquals(5, calculator.add(2, 3));
  }

  @Test
  public void testSubtraction() {
    assertEquals(1, calculator.subtract(3, 2));
  }

  @Test
  public void testMultiplication() {
    assertEquals(6, calculator.multiply(2, 3));
  }

  @Test
  @Tag("BAD")
  public void testDivision() {
    assertEquals(2, calculator.divide(6, 3));
  }

  @Test
  public void testDivisionByZero() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
  }

  @Test
  public void testIsEven() {
    assertTrue(calculator.isEven(4));
    assertFalse(calculator.isEven(3));
  }

  @Test
  public void testFactorial() {
    assertEquals(120, calculator.factorial(5));
    assertEquals(1, calculator.factorial(0));
  }

  @Test
  public void testMax() {
    assertEquals(5, calculator.max(3, 5));
    assertEquals(5, calculator.max(5, 3));
  }

  @Test
  public void testMin() {
    assertEquals(3, calculator.min(3, 5));
    assertEquals(3, calculator.min(5, 3));
  }

  @Test
  public void testAbs() {
    assertEquals(5, calculator.abs(-5));
    assertEquals(5, calculator.abs(5));
  }
}
