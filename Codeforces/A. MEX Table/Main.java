// https://codeforces.com/contest/2057/problem/A?locale=en

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            System.out.println(Math.max(n, m) + 1);
        }
    }
}
