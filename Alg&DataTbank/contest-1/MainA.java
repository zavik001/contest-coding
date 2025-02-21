import java.util.Scanner;

public class MainA {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < k; i ++) {
            if (binarySearch(in.nextInt())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        in.close();
    }

    static boolean binarySearch(int x) {
        boolean flag = false;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                flag = true;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return flag;
    }
}
