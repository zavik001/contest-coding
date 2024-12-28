import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int count = 0;
            int pre = 0;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (pre == 0 && num != 0) {
                    count++;
                }
                pre = num;
            }

            System.out.println(count >= 2 ? 2 : count);
        }
    }
}
