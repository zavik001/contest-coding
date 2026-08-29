import java.util.Scanner;

public class Counter {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(b >= a ? b - a : m - a + b);
    }
}
