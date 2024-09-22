import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int anss = (int) (n / Math.min(x, y)) + ((n % Math.min(x, y)) > 0 ? 1 : 0);
            System.out.println(anss);
        }
        scanner.close();
    }
}
