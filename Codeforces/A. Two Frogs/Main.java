// https://codeforces.com/contest/2055/problem/0

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int a = input.nextInt();
            int b = input.nextInt();

            int distance = Math.abs(a - b);

            if (distance % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        input.close();
    }
}
