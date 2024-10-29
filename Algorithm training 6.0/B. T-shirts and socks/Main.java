import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int flag = 0;

        if (A == 0 && C == 0 || B == 0 && D == 0) {
            System.out.println(1 + " " + 1);
            flag = 1;
        } else if (A == 0) {
            System.out.println(1 + " " + (C + 1));
            flag = 1;
        } else if (C == 0) {
            System.out.println((A + 1) + " " + 1);
            flag = 1;
        } else if (B == 0) {
            System.out.println(1 + " " + (D + 1));
            flag = 1;
        } else if (D == 0) {
            System.out.println((B + 1) + " " + 1);
            flag = 1;
        }

        int M1 = Math.min(A, B) + 1;
        int N1 = Math.min(C, D) + 1;
        if (A == B) {
            M1 = A;
        } else if (C == D) {
            N1 = C;
        }

        int M2 = Math.max(A, B) + 1;
        int N2 = Math.max(C, D) + 1;

        int falg2 = 0;
        if (M1 + N1 <= M2 + 1 && M1 + N1 <= N2 + 1 && flag == 0 && (A < B && C < D || B < A && D < C)) {
            System.out.println(M1 + " " + N1);
            falg2 = 1;
        } else if ((M2 + 1 <= M1 + N1 && M2 + 1 <= N2 + 1 && flag == 0) || falg2 == 0 && flag == 0 && M2 + 1 <= N2 + 1) {
            System.out.println(M2 + " " + 1);
            falg2 = 1;
        } else if ((N2 + 1 <= M1 + N1 && N2 + 1 <= M2 + 1 && flag == 0) || falg2 == 0 && flag == 0) {
            System.out.println(1 + " " + N2);
        }

        scanner.close();
    }
}