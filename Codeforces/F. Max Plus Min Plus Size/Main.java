import java.util.*;

public class Main {
    static final int INF = 1000100000;
    static int n, ans, mx;
    static int[] a = new int[200010];
    static int[] b = new int[200010];
    static Node[] tr = new Node[800010];

    static class Node {
        int[][] x = new int[2][2];
        int[][] y = new int[2][2];

        Node() {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    x[i][j] = -INF;
                    y[i][j] = 0;
                }
            }
        }
    }

    static Node merge(Node u, Node v) {
        Node res = new Node();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.x[i][j] = Math.max(Math.max(u.x[i][0] + v.y[1][j], u.x[i][1] + v.y[0][j]), 
                                       Math.max(u.y[i][0] + v.x[1][j], u.y[i][1] + v.x[0][j]));
                res.y[i][j] = Math.max(u.y[i][0] + v.y[1][j], u.y[i][1] + v.y[0][j]);
                res.x[i][j] = Math.max(res.x[i][j], -INF);
                res.y[i][j] = Math.max(res.y[i][j], res.x[i][j]);

                if (i > 0) {
                    res.x[i][j] = Math.max(res.x[i][j], res.x[0][j]);
                    res.y[i][j] = Math.max(res.y[i][j], res.y[0][j]);
                }
                if (j > 0) {
                    res.x[i][j] = Math.max(res.x[i][j], res.x[i][0]);
                    res.y[i][j] = Math.max(res.y[i][j], res.y[i][0]);
                }
            }
        }
        return res;
    }

    static void update(int o, int l, int r, int x) {
        if (l >= r) {
            if (a[l] == mx)
                tr[o].x[1][1] = 1;
            tr[o].y[1][1] = 1;
            return;
        }
        int md = (l + r) >> 1;
        int lc = o << 1;
        int rc = o << 1 | 1;

        if (x <= md) {
            update(lc, l, md, x);
        } else {
            update(rc, md + 1, r, x);
        }
        tr[o] = merge(tr[lc], tr[rc]);
    }

    static void solve() {
        ans = 0;
        mx = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            mx = Math.max(mx, a[i]);
            b[i] = i;
        }

        Arrays.sort(b, 1, n + 1, (x, y) -> a[y] - a[x]);

        for (int i = 1; i <= (n << 2); i++) {
            tr[i] = new Node();
        }

        for (int i = 1; i <= n; i++) {
            update(1, 1, n, b[i]);
            ans = Math.max(ans, tr[1].x[1][1] + a[b[i]]);
        }

        System.out.println(ans + mx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }
}
