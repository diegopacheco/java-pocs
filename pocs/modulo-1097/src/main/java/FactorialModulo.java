public class FactorialModulo {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = 10;
        long factorial = factorialModulo(n);
        System.out.println("Factorial of " + n + " modulo " + MOD + ": " + factorial);
    }

    public static long factorialModulo(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}