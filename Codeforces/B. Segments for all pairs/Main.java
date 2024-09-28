import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int q = input.nextInt();
            long[] x = new long[n + 1];
            HashMap<Long, Long> mp = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                x[i] = input.nextLong();
                long cnt = (n - 1) + (i - 1) * (n - i);
                mp.put(cnt, mp.getOrDefault(cnt, 0L) + 1);
            }

            for (int i = 1; i < n; i++) {
                long cnt = i * (n - i);
                mp.put(cnt, mp.getOrDefault(cnt, 0L) + (x[i + 1] - x[i] - 1));
            }

            while (q-- > 0) {
                long query = input.nextLong();
                System.out.print(mp.getOrDefault(query, 0L) + " ");
            }
            System.out.println();
            mp.clear();
        }

        input.close();
    }
}
