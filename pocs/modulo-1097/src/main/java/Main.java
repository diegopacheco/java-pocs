
public class Main{
  private static final int MOD = 1000000007;

  public static void main(String[] args) {
    int a = 123456789;
    int b = 987654321;

    int sum = (a + b) % MOD;
    int product = (int)((long)a * b % MOD); // Cast to long to avoid overflow

    System.out.println("Sum modulo " + MOD + ": " + sum);
    System.out.println("Product modulo " + MOD + ": " + product);
  }
}
