import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MainB {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String s = input.nextLine();
        int n = s.length();
        String patT = "tbank";
        String patS = "study";
        int len = 5;
        int m = n - len + 1;
        int INF = Integer.MAX_VALUE / 2;

        int[] costT = IntStream.range(0, m)
                .map(i -> (int) IntStream.range(0, len).filter(k -> s.charAt(i + k) != patT.charAt(k)).count())
                .toArray();

        int[] costS = IntStream.range(0, m)
                .map(i -> (int) IntStream.range(0, len).filter(k -> s.charAt(i + k) != patS.charAt(k)).count())
                .toArray();

        int[] prefixMinS = new int[m + 1];
        prefixMinS[0] = INF;
        for (int i = 0; i < m; i++) {
            prefixMinS[i + 1] = Math.min(prefixMinS[i], costS[i]);
        }

        int[] suffixMinS = new int[m + 1];
        suffixMinS[m] = INF;
        for (int i = m - 1; i >= 0; i--) {
            suffixMinS[i] = Math.min(suffixMinS[i + 1], costS[i]);
        }

        int ans = INF;
        for (int i = 0; i < m; i++) {
            int minLeft = (i >= len) ? prefixMinS[i - len + 1] : INF;
            int minRight = (i + len < m) ? suffixMinS[i + len] : INF;
            int minCS = Math.min(minLeft, minRight);
            if (minCS != INF) {
                ans = Math.min(ans, costT[i] + minCS);
            }
        }

        printLine.accept(String.valueOf(ans));
    }
}
