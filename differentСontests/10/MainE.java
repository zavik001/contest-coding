import java.util.Scanner;
import java.util.function.Consumer;

public class MainE {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int num : a) {
            max = Math.max(max, num);
        }
        int countMax = 0;
        int sec = Integer.MIN_VALUE;
        for (int num : a) {
            if (num == max) {
                countMax++;
            } else {
                sec = Math.max(sec, num);
            }
        }
        int S = (countMax >= 2) ? max : (sec == Integer.MIN_VALUE ? max : sec);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append((i % 2 == 1) ? S : max);
            if (i < n) {
                sb.append(" ");
            }
        }
        printLine.accept(sb.toString());
    }
}
