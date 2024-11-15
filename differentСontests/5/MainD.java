import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainD {

    private static final int MAXN = 10_000_000;
    private static List<Integer> primes = new ArrayList<>();
    private static int[] p = new int[MAXN];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        long r = in.nextLong();
        in.close();

        generatePrimes();
        long answer = calculateAnswer(l, r);
        System.out.println(answer);
    }

    private static void generatePrimes() {
        for (int i = 0; i < MAXN; i++) {
            p[i] = 1;
        }
        p[0] = p[1] = 0;

        for (int i = 2; i < MAXN; i++) {
            if (p[i] == 1) {
                primes.add(i);
                for (int j = 2 * i; j < MAXN; j += i) {
                    p[j] = 0;
                }
            }
        }
    }

    private static long calculateAnswer(long l, long r) {
        long ans = 0;

        for (int prime : primes) {
            if (prime > r) break;

            long x = prime;
            long R = r;
            long L = l - 1;
            int degIn = 0;
            int degOut = 0;

            while (R / x > 0) {
                degIn++;
                R /= x;
            }

            while (L / x > 0) {
                degOut++;
                L /= x;
            }

            for (int deg = degOut + 1; deg <= degIn; deg++) {
                if (deg > 1 && p[deg + 1] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
