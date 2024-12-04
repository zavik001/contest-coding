import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ai = new int[n];

        for (int i = 0; i < n; i++) {
            ai[i] = scanner.nextInt();
        }

        scanner.close();

        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (ai[i] < ai[i - 1]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            int t = ai[n - 1];
            int firstElement = ai[0];
            System.out.println(t - firstElement);
        } else {
            System.out.println(-1);
        }

    }
}