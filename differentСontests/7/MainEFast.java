import java.util.Scanner;

public class MainEFast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long s = in.nextLong();
        long[] a = new long[n + 1];
        long[] prefixSum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        in.close();

        long total = 0;

        for (int l = 1; l <= n; l++) {
            int low = l, high = n;
            int bestR = l - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                long sum = prefixSum[mid] - prefixSum[l - 1];

                if (sum <= s) {
                    bestR = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (bestR >= l) {
                total += (bestR - l + 1);
            }

            for (int r = bestR + 1; r <= n; r++) {
                long sum = prefixSum[r] - prefixSum[l - 1];
                total += (sum + s - 1) / s;
            }
        }

        System.out.println(total);
    }
}
