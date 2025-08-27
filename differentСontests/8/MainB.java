import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MainB {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int t = input.nextInt();
        for (int test = 0; test < t; test++) {
            int N = input.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = input.nextInt();
            }
            long sum = Arrays.stream(a).sum();
            Arrays.sort(a);
            boolean valid = IntStream.range(1, N + 1).allMatch(k -> a[k - 1] <= k);
            String ans;
            if (!valid) {
                ans = "Second";
            } else {
                long maxSum = (long) N * (N + 1) / 2;
                long m = maxSum - sum;
                ans = (m % 2 == 1) ? "First" : "Second";
            }
            printLine.accept(ans);
        }
    }
}
