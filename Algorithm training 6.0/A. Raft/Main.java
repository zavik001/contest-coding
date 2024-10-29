import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x < x1 && y > y2) {
            System.out.println("NW");
        } else if (x > x2 && y > y2) {
            System.out.println("NE");
        } else if (x < x1 && y < y1) {
            System.out.println("SW");
        } else if (x > x2 && y < y1) {
            System.out.println("SE");
        } else if (y > y2) {
            System.out.println("N");
        } else if (y < y1) {
            System.out.println("S");
        } else if (x < x1) {
            System.out.println("W");
        } else if (x > x2) {
            System.out.println("E");
        }

        scanner.close();
    }
}
