
/*************  ✨ Codeium Command 🌟  *************/
import java.util.Scanner;

public class MainB {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < k; i++) {
            System.out.println(binarySearchMin(in.nextInt()));
        }

        in.close();
    }

    static int binarySearchMin(int x) {
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = arr.length - 1;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int diff = Math.abs(arr[mid] - x);
            if (diff < minDiff) {
                minDiff = diff;
                result = arr[mid];
            } else if (diff == minDiff) {
                result = Math.min(result, arr[mid]);
            }
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
