import java.util.*;

public class MainE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean[] vis = new boolean[n + 1];
        List<int[]> pairs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                List<Integer> color0 = new ArrayList<>();
                List<Integer> color1 = new ArrayList<>();
                int[] col = new int[n + 1];
                Arrays.fill(col, -1);
                Queue<Integer> q = new LinkedList<>();
                col[i] = 0;
                color0.add(i);
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj[u]) {
                        if (col[v] == -1) {
                            col[v] = 1 - col[u];
                            if (col[v] == 0)
                                color0.add(v);
                            else
                                color1.add(v);
                            q.add(v);
                            vis[v] = true;
                        }
                    }
                }
                List<Integer> chosen = null;
                if (color0.size() >= 2) {
                    chosen = color0;
                } else if (color1.size() >= 2) {
                    chosen = color1;
                }
                if (chosen != null) {
                    Collections.sort(chosen);
                    int u = chosen.get(0);
                    int v = chosen.get(1);
                    pairs.add(new int[] { u, v });
                }
            }
        }
        System.out.println(pairs.size());
        for (int j = 0; j < pairs.size(); j++) {
            int[] p = pairs.get(j);
            System.out.print(p[0] + " " + p[1]);
            if (j < pairs.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        sc.close();
    }
}