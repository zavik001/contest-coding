import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = input.nextInt();
            }

            int max = 0;

            for (int i = 1; i <= n; i++) {
                int computedValue;
                if (n % 2 == 0) {
                    computedValue = a[i] + n / 2;
                } else {
                    computedValue = a[i] + (i % 2 == 0 ? n / 2 : n / 2 + 1);
                }

                if (computedValue > max) {
                    max = computedValue;
                }
            }

            System.out.println(max);
        }
        input.close();
    }
}
