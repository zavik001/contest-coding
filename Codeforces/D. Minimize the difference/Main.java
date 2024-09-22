import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (; t > 0; t--) {
            int n = scanner.nextInt();
            List<Long> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long x = scanner.nextLong();
                a.add(x);
            }

            long max = -100000000000000L;
            long min = 100000000000000L;
            long r = 0;

            for (int i = 1; i < n; i++) {
                if (a.get(i - 1) > a.get(i)) {
                    r = a.get(i - 1) - a.get(i);
                    long half = r / 2;

                    if (r % 2 == 1) {
                        a.set(i - 1, a.get(i - 1) - half);
                        a.set(i, a.get(i) + half + 1);
                    } else {
                        a.set(i - 1, a.get(i - 1) - half);
                        a.set(i, a.get(i) + half);
                    }
                }

                if (a.get(i) > max) {
                    max = a.get(i);
                }
                if (a.get(i) < min) {
                    min = a.get(i);
                }
            }

            if (a.get(0) > max) {
                max = a.get(0);
            }
            if (a.get(0) < min) {
                min = a.get(0);
            }

            System.out.println(max - min);
        }

        scanner.close();
    }
}
