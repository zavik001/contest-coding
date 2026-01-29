import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainJ {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);
    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        List<Integer> groupEven = new ArrayList<>();
        List<Integer> groupOdd = new ArrayList<>();
        for (int s = 2; s <= 2 * n; s++) {
            int low = Math.max(1, s - n);
            int high = Math.min(n, s - 1);
            int sz = high - low + 1;
            if ((s % 2) == 0) {
                groupEven.add(sz);
            } else {
                groupOdd.add(sz);
            }
        }
        Collections.sort(groupEven);
        Collections.sort(groupOdd);
        long[] waysEven = computeWays(groupEven, k, MOD);
        long[] waysOdd = computeWays(groupOdd, k, MOD);
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = (ans + waysEven[i] * waysOdd[k - i] % MOD) % MOD;
        }
        printLine.accept(String.valueOf(ans));
    }

    private static long[] computeWays(List<Integer> sizes, int maxK, long mod) {
        int len = sizes.size();
        long[][] dp = new long[len + 1][maxK + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int sz = sizes.get(i - 1);
            for (int j = 0; j <= maxK; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    long temp = sz - (j - 1);
                    if (temp > 0) {
                        dp[i][j] = (dp[i][j] + temp * dp[i - 1][j - 1] % mod) % mod;
                    }
                }
            }
        }
        return dp[len];
    }
}
