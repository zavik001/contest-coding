import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for (int test = 0; test < tests; test++) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k == n * n - 1) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            int full = k / n;
            int extra = k % n;

            for (int i = 0; i < full; i++) {
                for (int j = 0; j < n; j++) System.out.print("U");
                System.out.println();
            }

            if (extra > 0) {
                for (int j = 0; j < extra; j++) System.out.print("U");
                if (n - extra == 1) {
                    System.out.println("D");
                } else {
                    for (int j = extra; j < n - 1; j++) System.out.print("R");
                    System.out.println("L");
                }
            }

            int rows_left = n - full - (extra > 0 ? 1 : 0);
            for (int i = 0; i < rows_left; i++) {
                for (int j = 0; j < n - 1; j++) System.out.print("R");
                System.out.println("L");
            }
        }
    }
}
