import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class MainF {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);
    static List<Integer>[] adj;
    static int[] outPar;
    static boolean[] visited;
    static Set<Long> toFlip;
    static List<int[]> dirs;
    static int N, currentSumDeg;
    static boolean impossible = false;

    public static void main(String[] args) {
        N = input.nextInt();
        int M = input.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        outPar = new int[N + 1];
        dirs = new ArrayList<>();
        toFlip = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            adj[u].add(v);
            adj[v].add(u);
            int min = Math.min(u, v);
            int max = Math.max(u, v);
            dirs.add(new int[] {min, max});
            outPar[min] ^= 1;
        }
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                currentSumDeg = 0;
                visited[i] = true;
                int extra = dfs(i, -1);
                int m_comp = currentSumDeg / 2;
                if (m_comp % 2 == 1 || extra != 0) {
                    impossible = true;
                    break;
                }
            }
        }
        if (impossible) {
            printLine.accept("-1");
        } else {
            for (int[] dir : dirs) {
                int from = dir[0];
                int to = dir[1];
                long key = (long) from * (N + 1L) + to;
                if (toFlip.contains(key)) {
                    printLine.accept(to + " " + from);
                } else {
                    printLine.accept(from + " " + to);
                }
            }
        }
    }

    static int dfs(int v, int par) {
        currentSumDeg += adj[v].size();
        int sum_children = 0;
        for (int child : adj[v]) {
            if (child == par)
                continue;
            if (visited[child]) {
                continue;
            }
            visited[child] = true;
            int y = dfs(child, v);
            sum_children ^= y;
            if (y == 1) {
                int min = Math.min(v, child);
                int max = Math.max(v, child);
                long key = (long) min * (N + 1L) + max;
                toFlip.add(key);
            }
        }
        int y_to_par = outPar[v] ^ sum_children;
        return y_to_par;
    }
}
