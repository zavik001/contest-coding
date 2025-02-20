import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println(mid);
            System.out.flush();
            String s = in.next();
            if (s.equals("<")) {
                r = mid - 1;
            } else if (s.equals(">=")) {
                l = mid + 1;
            }
        }
        System.out.println("! " + r);
        System.out.flush();
    }
}
