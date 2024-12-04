
import java.util.Scanner;

public class MainD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long A = in.nextLong();
            long B = in.nextLong();
            System.out.println(maxGcd(A, B));
        }
        in.close();
    }

    public static long maxGcd(long A, long B) {
        long gcd = gcd(A, B);
        Long maxGcd = Math.max(largestPrimeFactor(A/gcd), largestPrimeFactor(B/gcd)); 
        return maxGcd * gcd;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long largestPrimeFactor(long A) {
        long maxPrime = 1;

        while (A % 2 == 0) {
            maxPrime = 2;
            A /= 2;
        }

        for (long i = 3; i * i <= A; i += 2) {
            while (A % i == 0) {
                maxPrime = i;
                A /= i;
            }
        }

        if (A > 2) {
            maxPrime = A;
        }

        return maxPrime;
    }
}
