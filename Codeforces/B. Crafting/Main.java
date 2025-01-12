// https://codeforces.com/contest/2055/problem/B?locale=ru

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = input.nextInt();
            }

            int count = 0;
            int ind = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) {
                    ind = i;
                    count++;
                }
            }

            int x = b[ind] - a[ind];
            boolean flag = false;

            if (count == 1) {
                for (int i = 0; i < n; i++) {
                    if (i == ind) continue;
                    if (b[i] + x > a[i]) {
                        flag = true;
                        break;
                    }
                }
            }

            System.out.println((count > 1 || (count == 1 && flag)) ? "NO" : "YES");
        }

        input.close();
    }
}