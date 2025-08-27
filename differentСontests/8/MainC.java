import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainC {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int N = input.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x = input.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        long res = 1;
        for (int k : map.values()) {
            res = res * (1L + k) % MOD;
        }
        res = (res - 1 + MOD) % MOD;
        printLine.accept(res + "");
    }
}
