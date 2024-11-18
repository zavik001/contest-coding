import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long xsum = 0, ysum = 0;

        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            xsum += x;
            ysum += y;
        }

        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            xsum -= x;
            ysum -= y;
        }

        scanner.close();

        System.out.println((-xsum / n) + " " + (-ysum / n));
    }
}
