import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }
        in.close();

        validateAndAdjust(n, a);
    }

    private static void validateAndAdjust(int n, List<Integer> a) {
        List<Integer> result = new ArrayList<>(a);

        if (result.get(0) == -1) {
            result.set(0, 1);
        }

        for (int i = 1; i < n; i++) {
            if (result.get(i) == -1) {
                result.set(i, result.get(i - 1) + 1);
            } else if (result.get(i) <= result.get(i - 1)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        System.out.print(result.get(0) + " ");
        for (int i = 1; i < n; i++) {
            System.out.print((result.get(i) - result.get(i - 1)) + " ");
        }
        System.out.println();
    }
}
