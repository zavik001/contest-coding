import java.util.Scanner;

public class MainE {

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
            for (int r = l; r <= n; r++) {
                long sum = prefixSum[r] - prefixSum[l - 1];
                if (sum <= s) {
                    total += 1;
                } else {
                    total += (sum + s - 1) / s;
                }
            }
        }

        System.out.println(total);
    }
}
