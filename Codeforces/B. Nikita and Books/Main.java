
// https://codeforces.com/contest/2244/problem/B?locale=en
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = in.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            solve(a);
        }
    }

    private static void solve(long[] a) {
        long prefSum = 0;
        long minNeed = 0;
        for (int i = 0; i < a.length; i++) {
            prefSum += a[i];
            minNeed += (i + 1);
            if (minNeed > prefSum) {
                printLine.accept("NO");
                return;
            }
        }
        printLine.accept("YES");
    }
}
