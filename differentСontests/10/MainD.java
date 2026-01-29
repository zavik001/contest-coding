import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainD {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = input.nextInt();
        int m = input.nextInt();
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        int minCycle = Integer.MAX_VALUE;
        for (int start = 1; start <= n; start++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);
            dist[start] = 0;
            int[] parent = new int[n + 1];
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.add(v);
                    } else if (v != parent[u]) {
                        int cycle = dist[u] + dist[v] + 1;
                        minCycle = Math.min(minCycle, cycle);
                    }
                }
            }
        }
        printLine.accept(minCycle == Integer.MAX_VALUE ? "-1" : String.valueOf(minCycle));
    }
}
