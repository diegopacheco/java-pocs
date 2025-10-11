
public class Calculator {

  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return a / b;
  }

  public boolean isEven(int n) {
    return n % 2 == 0;
  }

  public int factorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Negative number");
    }
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public int max(int a, int b) {
    return a > b ? a : b;
  }

  public int min(int a, int b) {
    return a < b ? a : b;
  }

  public int abs(int n) {
    return n < 0 ? -n : n;
  }

  public int power(int base, int exp) {
    if (exp < 0) {
      throw new IllegalArgumentException("Negative exponent");
    }
    if (exp == 0) {
      return 1;
    }
    int result = 1;
    for (int i = 0; i < exp; i++) {
      result *= base;
    }
    return result;
  }
}
