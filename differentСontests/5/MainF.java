import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class MainF {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        List<Integer> t = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> deg = new ArrayList<>(Collections.nCopies(n, 0));
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            List<Integer> numbers = getSplit(line);
            t.set(i, numbers.get(0));

            for (int j = 1; j < numbers.size(); j++) {
                int to = numbers.get(j) - 1;
                edges.get(to).add(i);
                deg.set(i, deg.get(i) + 1);
            }
        }
        in.close();

        int result = solve(n, t, deg, edges);
        System.out.println(result);
    }

    private static List<Integer> getSplit(String s) {
        List<Integer> res = new ArrayList<>();
        int x = 0;
        boolean foundDigit = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (foundDigit) {
                    res.add(x);
                    x = 0;
                    foundDigit = false;
                }
            } else {
                x = x * 10 + (ch - '0');
                foundDigit = true;
            }
        }
        if (foundDigit) {
            res.add(x);
        }
        return res;
    }

    private static int solve(int n, List<Integer> t, List<Integer> deg, List<List<Integer>> edges) {
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int v = 0; v < n; v++) {
            if (deg.get(v) == 0) {
                dq.add(v);
            }
        }

        while (!dq.isEmpty()) {
            int v = dq.poll();
            dp[v] += t.get(v);

            for (int to : edges.get(v)) {
                deg.set(to, deg.get(to) - 1);
                dp[to] = Math.max(dp[to], dp[v]);
                if (deg.get(to) == 0) {
                    dq.add(to);
                }
            }
        }

        int ans = 0;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}
