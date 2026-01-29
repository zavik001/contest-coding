import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainF {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = input.nextInt();
        int qq = input.nextInt();
        input.nextLine();
        String s = input.nextLine();
        List<long[]> ops = new ArrayList<>();
        long len = n;
        for (int i = 0; i < qq; i++) {
            int type = input.nextInt();
            if (type == 1) {
                long l = input.nextLong();
                long r = input.nextLong();
                ops.add(new long[]{l, r});
                len += r - l + 1;
            } else {
                long pos = input.nextLong();
                long cur = pos;
                for (int j = ops.size() - 1; j >= 0; j--) {
                    long[] op = ops.get(j);
                    long l = op[0], r = op[1], d = r - l + 1;
                    if (cur < l) continue;
                    if (cur > l + 2 * d - 1) {
                        cur -= d;
                    } else {
                        cur = l + (cur - l) / 2;
                    }
                }
                printLine.accept(String.valueOf(s.charAt((int) cur - 1)));
            }
        }
    }
}
