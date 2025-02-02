import java.util.Scanner;

public class MainA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int r = 0;
        int m = 0;
        for (int i = 0; i < 3; i++) {
            if (s.charAt(i) == 'R') {
                r = i;
            }
            if (s.charAt(i) == 'M') {
                m = i;
            }
        }

        if (r < m) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        in.close();
    }
}
