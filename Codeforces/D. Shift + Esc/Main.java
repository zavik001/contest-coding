import java.util.Scanner;

public class Main {
    static final long INF = (long) 1e16;
    static long[][] a = new long[205][205];
    static long[][][] dp = new long[205][205][205];
    static long[][] mn = new long[205][205];

    public static void solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextLong();
                mn[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][0][i] = a[0][i] + k * i;
            mn[0][0] = Math.min(mn[0][0], dp[0][0][i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int s = 0; s < m; s++) {
                    if (i == 0 && j == 0) continue;

                    dp[i][j][s] = (j > 0) ? dp[i][j - 1][s] : INF;
                    long num = (i > 0) ? mn[i - 1][j] : INF;
                    dp[i][j][s] = Math.min(dp[i][j][s], num + k * s) + a[i][(j + s) % m];
                    mn[i][j] = Math.min(mn[i][j], dp[i][j][s]);
                }
            }
        }

        System.out.println(mn[n - 1][m - 1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            solve(in);
        }
    }
}
