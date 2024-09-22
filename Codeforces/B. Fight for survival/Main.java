import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextInt();
            List<Long> a = new ArrayList<>();
            for (long i = 0; i < n; i++) {
                long e = scanner.nextLong();
                a.add(e);
            }
            long sum = a.get((int)(n - 2));
            for (long i = n - 2; i > 0; i--) {
                sum = a.get((int)i) - a.get((int)(i - 1));
                a.set((int)(i - 1), sum);
            }
            sum = a.get((int)(n - 1)) - sum;
            System.out.println(sum);
        }
        scanner.close();
    }
}
