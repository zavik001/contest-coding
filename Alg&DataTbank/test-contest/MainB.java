import java.util.Scanner;
import java.util.Arrays;

public class MainB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        in.close();

        Arrays.sort(arr);

        if (k == 0) {
            if (arr[0] > 1) {
                System.out.println(arr[0] - 1);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int x = arr[k - 1];

        if (k < n && arr[k] == x) {
            System.out.println(-1);
        } else {
            System.out.println(x);
        }
    }
}
