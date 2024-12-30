import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();

        while (q-- > 0) {
            solve(input);
        }
    }

    public static void solve(Scanner input) {
        String s = input.next();
        String t = input.next();

        String commonPrefix = findCommonPrefix(s, t);
        int ans = s.length() + t.length() - commonPrefix.length() + (commonPrefix.length() > 0 ? 1 : 0);

        System.out.println(ans);
    }

    public static String findCommonPrefix(String s, String t) {
        StringBuilder commonPrefix = new StringBuilder();
        int minLength = Math.min(s.length(), t.length());

        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonPrefix.append(s.charAt(i));
            } else {
                break;
            }
        }

        return commonPrefix.toString();
    }
}