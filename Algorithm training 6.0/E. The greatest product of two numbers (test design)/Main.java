import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int min1 = arr[0], min2 = arr[1], max1 = arr[0], max2 = arr[1];

        for (int i = 0; i < n; i++) {
            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max2 = arr[i];
            }
        }

        if (max1 * max2 < min1 * min2) {
            System.out.println(min2 + " " + min1);
        } else {
            System.out.println(max2 + " " + max1);
        }

        scanner.close();
    }
}