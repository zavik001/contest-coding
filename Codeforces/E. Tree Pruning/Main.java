import java.util.*;

public class Main {
    static final int N = 500007;
    static int T, ans, n, nw;
    static List<Integer>[] e = new ArrayList[N];
    static boolean[] vis = new boolean[N];
    static int[] dep = new int[N];
    static int[] cnt = new int[N];
    static int[] ff = new int[N];
    static int[] sn = new int[N];
    static List<Integer>[] lf = new ArrayList[N];

    static {
        for (int i = 0; i < N; i++) {
            e[i] = new ArrayList<>();
            lf[i] = new ArrayList<>();
        }
    }

    public static void dfs(int x, int fa) {
        int sz = e[x].size();
        if (fa != 0) sz--;
        if (sz == 0) {
            lf[dep[x]].add(x);
        }
        cnt[dep[x]]++;
        for (int v : e[x]) {
            if (v != fa) {
                sn[x]++;
                ff[v] = x;
                dep[v] = dep[x] + 1;
                dfs(v, x);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
        while (T-- > 0) {
            nw = 0;
            n = sc.nextInt();
            ans = n - 1;

            Arrays.fill(vis, 1, n + 1, false);
            vis[1] = true;

            for (int i = 1; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                e[u].add(v);
                e[v].add(u);
            }

            dep[1] = 1;
            dfs(1, 0);

            for (int i = n - 1; i > 0; i--) {
                cnt[i] += cnt[i + 1];
            }

            for (int de = 1; de <= n; de++) {
                for (int x : lf[de - 1]) {
                    int hp = x;
                    while (sn[hp] == 0) {
                        vis[hp] = true;
                        nw++;
                        sn[ff[hp]]--;
                        hp = ff[hp];
                    }
                }
                int cst = cnt[de + 1] + nw;
                ans = Math.min(ans, cst);
            }

            
            for (int i = 1; i <= n; i++) {
                e[i].clear();
                lf[i].clear();
                cnt[i] = 0;
                ff[i] = 0;
                sn[i] = 0;
            }

            System.out.println(ans);
        }
        sc.close();
    }
}
