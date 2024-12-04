import java.math.BigInteger;
import java.util.Scanner;

public class MainC {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(calculateMod(n));
    }

    public static int calculateMod(int n) {
        long result = 0;
        long[] binomials = new long[n];
        binomials[0] = 1;

        for (int k = 1; k < n; k++) {
            binomials[k] = binomials[k - 1] * (n - k) % MOD * modInverse(k, MOD) % MOD;
        }

        for (int k = 0; k < n; k++) {
            int sign = (k % 2 == 0) ? 1 : -1;

            long binomial1 = binomials[k];
            long exponent = (long) ((n - 1 - k) * (n - 2 - k) / 2);
            long power = modPow(2, exponent, MOD);

            long term = (sign * binomial1 % MOD * power % MOD + MOD) % MOD;
            result = (result + term) % MOD;
        }

        result = (result * n) % MOD;
        if (result < 0) {
            result += MOD;
        }

        return (int) result;
    }

    private static long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    private static long modInverse(long a, int mod) {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(mod)).longValue();
    }
}
