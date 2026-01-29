import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainC {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(input.nextLine());
        for (int i = 0; i < t; i++) {
            String s = input.nextLine();
            int n = s.length();
            String[] onesRuns = s.split("0");
            int maxLinear = Arrays.stream(onesRuns).mapToInt(String::length).max().orElse(0);
            int wrap = 0;
            if (n > 0 && s.charAt(0) == '1' && s.charAt(n - 1) == '1' && onesRuns.length > 0) {
                wrap = onesRuns[0].length() + onesRuns[onesRuns.length - 1].length();
            }
            int L = Math.max(maxLinear, wrap);
            L = Math.min(L, n);
            long ans = (L == n) ? (long) n * n : (long) ((L + 1) / 2) * ((L + 1) - (L + 1) / 2);
            printLine.accept(String.valueOf(ans));
        }
    }
}
