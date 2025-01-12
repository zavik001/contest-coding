// https://codeforces.com/contest/2055/problem/C

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            String s = input.next();

            long[][] a = new long[n][m];
            long[] rowSum = new long[n];
            long[] colSum = new long[m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = input.nextLong();
                    rowSum[i] += a[i][j];
                    colSum[j] += a[i][j];
                }
            }

            int x = 0, y = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'D') {
                    a[x][y] = -rowSum[x];
                    colSum[y] += -rowSum[x];
                    x++;
                } else {
                    a[x][y] = -colSum[y];
                    rowSum[x] += -colSum[y];
                    y++;
                }
            }
            a[x][y] = -rowSum[x];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }

        input.close();
    }
}
