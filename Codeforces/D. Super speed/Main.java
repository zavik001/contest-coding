import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            solve(input);
        }

        input.close();
    }

    static void solve(Scanner input) {
        int n = input.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];

        int L = 1, R = n;

        for (int i = 1; i <= n; i++) {
            b[i] = n + 1;
            c[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
            b[a[i]] = Math.min(b[a[i]], i);
            c[a[i]] = Math.max(c[a[i]], i);
        }

        for (int i = 2; i <= n; i++) {
            b[i] = Math.min(b[i], b[i - 1]);
            c[i] = Math.max(c[i], c[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            L = Math.max(L, c[i] - i + 1);
            R = Math.min(R, b[i] + i - 1);
            if (c[i] - b[i] + 1 > i) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(Math.max(R - L + 1, 0));
    }
}
