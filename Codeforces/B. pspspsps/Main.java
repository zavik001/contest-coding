import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();
        while (q-- > 0) {
            int n = in.nextInt();
            in.nextLine();
            String s = in.nextLine();

            int[] val = new int[n];
            int cur = 0;
            int num = 1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'p') {
                    for (int j = i; j >= cur; j--) {
                        val[j] = num++;
                    }
                    cur = i + 1;
                }
            }

            for (int i = n - 1; i >= cur; i--) {
                val[i] = num++;
            }

            int sum = 0;
            int i;

            for (i = n - 1; i >= 0; i--) {
                sum += val[i];

                if (s.charAt(i) == 's') {
                    int x = n - i;
                    if (sum != (x * (x + 1)) / 2) {
                        System.out.println("NO");
                        break;
                    }
                }
            }

            if (i < 0) {
                System.out.println("YES");
            }
        }
    }
}