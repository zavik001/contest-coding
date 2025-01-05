// https://codeforces.com/contest/2057/problem/C

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            int k = 31 - Long.numberOfLeadingZeros(l ^ r);

            long a = ((1 << k) - 1) | l;
            long b = a + 1;
            long c = (a == l) ? r : l;

            System.out.println(a + " " + b + " " + c);
        }
    }
}
