import java.util.Scanner;

public class Main {

    public volatile static int c = 0;
    public volatile static int l = 0;
    public volatile static int r = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        for (int test = 0; test < tests; test++) {
            c = 0;
            l = 0;
            r = 0;
            int n = in.nextInt();
            solve(n);
            System.out.println("" + c);
        }
    }

    public static void col(int x, boolean flag) {
        c = c + x / 2;
        if (!flag) {
            l = l - l / 2;
        } else {
            l = l + r / 2;
            r = r - r / 2;
        }
    }

    public static void solve(int n) {
        c = c + n / 2;
        r = n - n / 2;
        l = n / 2;
        int tt = 0;
        while (r > 1 || l > 1) {
            tt++;
            if (l > 1) {
                col(l, false);
            }
            if (r > 1) {
                col(r, true);
            }
        }
        c = c + 1;
    }
}
