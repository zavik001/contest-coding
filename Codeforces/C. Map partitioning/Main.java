import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            long k = input.nextLong();
            long[] a = new long[n];

            long maxn = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = input.nextLong();
                maxn = Math.max(maxn, a[i]);
                sum += a[i];
            }

            long ans = 1;
            for (int i = 1; i <= n; i++) {
                long minn = Math.max(maxn * i, ((sum + i - 1) / i) * i);
                if (minn <= sum + k) {
                    ans = Math.max(ans, i);
                }
            }

            System.out.println(ans);
        }
    }
}
