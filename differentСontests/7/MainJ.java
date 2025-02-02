import java.util.Scanner;

public class MainJ {

    static final long MOD = 998244353;
    static final int MAXK = 300;

    static long add(long a, long b) {
        a += b;
        if (a >= MOD) {
            a -= MOD;
        }
        return a;
    }

    static long sub(long a, long b) {
        a -= b;
        if (a < 0) {
            a += MOD;
        }
        return a;
    }

    static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        in.close();

        long[] S = new long[k + 1];
        S[0] = n % MOD;
        for (int i = 0; i < n; i++) {
            long x = 1;
            for (int t = 1; t <= k; t++) {
                x = mul(x, a[i]);
                S[t] = add(S[t], x);
            }
        }

        long[][] binom = new long[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            binom[i][0] = 1;
            binom[i][i] = 1;
            for (int j = 1; j < i; j++) {
                binom[i][j] = add(binom[i - 1][j - 1], binom[i - 1][j]);
            }
        }

        long[] two = new long[k + 1];
        two[0] = 1;
        for (int p = 1; p <= k; p++) {
            two[p] = mul(two[p - 1], 2);
        }
        long inv2 = 499122177;

        for (int p = 1; p <= k; p++) {

            long firstPart = 0;
            for (int r = 0; r <= p; r++) {
                long tmp = mul(binom[p][r], S[r]);
                tmp = mul(tmp, S[p - r]);
                firstPart = add(firstPart, tmp);
            }
            firstPart = mul(firstPart, inv2);

            long secondPart = mul(two[p - 1], S[p]);

            long res = sub(firstPart, secondPart);

            System.out.println(res);
        }
    }
}
