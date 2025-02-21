import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class MainASet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(in.nextInt());
        }

        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            if (s.contains(x)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        in.close();
    }
}
