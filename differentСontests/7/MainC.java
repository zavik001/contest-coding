import java.util.Scanner;

public class MainC {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int a1 = a[0];
        int a2 = a[1];
        int[] corrections = new int[n - 2];
        int index = 0;

        for (int i = 2; i < n; i++) {
            if (a[i] < a1) {
                corrections[index++] = a1 - a[i];
            } else if (a[i] > a2) {
                corrections[index++] = a[i] - a2;
            } else {
                corrections[index++] = 0;
            }
        }

        java.util.Arrays.sort(corrections);

        int totalCorrections = 0;
        for (int i = 0; i < m; i++) {
            totalCorrections += corrections[i];
        }

        System.out.println(totalCorrections);

        in.close();
    }
}
