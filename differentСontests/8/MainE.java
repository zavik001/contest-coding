import java.util.Scanner;
import java.util.function.Consumer;

public class MainE {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int N = input.nextInt();
        int K = input.nextInt();
        long[] part = new long[N + 1];
        part[0] = 1;
        for (int v = 1; v <= N; v++) {
            for (int s = v; s <= N; s++) {
                part[s] = (part[s] + part[s - v]) % MOD;
            }
        }
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= K; j++) {
            for (int s = 0; s <= N; s++) {
                for (int t = 0; t <= s; t++) {
                    dp[j][s] = (dp[j][s] + dp[j - 1][s - t] * part[t] % MOD) % MOD;
                }
            }
        }
        printLine.accept(dp[K][N] + "");
    }
}
