import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            x--;
            y--;
            int[] ans = new int[n];

            if (n % 2 == 0 && Math.abs(x - y) % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    ans[i] = i % 2;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (i == x) {
                        ans[i] = 2;
                    } else {
                        ans[i] = ((i - x + n) % n) % 2;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
