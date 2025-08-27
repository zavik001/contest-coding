import java.util.Scanner;
import java.util.function.Consumer;

public class MainD {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int N = input.nextInt();
        long[] l = new long[N + 1];
        long[] r = new long[N + 1];
        long[] a = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            l[i] = input.nextLong();
            r[i] = input.nextLong();
            a[i] = input.nextLong();
        }
        long[] prefix = new long[N + 1];
        prefix[1] = a[1];
        for (int i = 2; i <= N; i++) {
            long pushed = Math.min(l[i], prefix[i - 1]);
            prefix[i] = a[i] + pushed;
        }
        long[] suffix = new long[N + 1];
        suffix[N] = a[N];
        for (int i = N - 1; i >= 1; i--) {
            long pushed = Math.min(r[i], suffix[i + 1]);
            suffix[i] = a[i] + pushed;
        }
        long max = 0;
        for (int k = 1; k <= N; k++) {
            long fk = prefix[k] + suffix[k] - a[k];
            max = Math.max(max, fk);
        }
        printLine.accept(max + "");
    }
}
