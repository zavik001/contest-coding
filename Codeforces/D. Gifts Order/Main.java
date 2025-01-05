// https://codeforces.com/contest/2057/problem/D

import java.io.*;
import java.util.*;

public class Dq {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(r.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            int[] b = new int[N];
            st = new StringTokenizer(r.readLine());

            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                b[N - i - 1] = a[i];
            }
            SegTree at = new SegTree(N, a);
            SegTree bt = new SegTree(N, b);
            pw.println(Math.max(at.query(), bt.query()));
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(r.readLine());
                int p = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken());
                at.update(p, x);
                bt.update(N - 1 - p, x);
                pw.println(Math.max(at.query(), bt.query()));
            }

        }
        pw.close();
    }

}

class SegTree {
    int N = 1;
    int[][] tr; // left, right, sz, best

    public SegTree(int n, int[] vals) {
        while (N <= n)
            N *= 2;
        tr = new int[2 * N][4];
        for (int i = 0; i < n; i++)
            tr[i + N] = new int[] { i - vals[i], vals[i] - i, 1, 0 };
        for (int i = n; i < N; i++)
            tr[i + N][2] = -1;
        for (int i = N - 1; i > 0; i--) {
            int[] v = new int[4];
            v[0] = Math.max(tr[i * 2][0], tr[i * 2 + 1][0]);
            v[1] = Math.max(tr[i * 2][1], tr[i * 2 + 1][1]);
            v[2] = 7;
            v[3] = Math.max(Math.max(tr[i * 2][3], tr[i * 2 + 1][3]), tr[i * 2][0] + tr[i * 2 + 1][1]);
            if (tr[i * 2 + 1][2] == -1) {
                v[0] = tr[i * 2][0];
                v[1] = tr[i * 2][1];
                v[2] = tr[i * 2][2];
                v[3] = tr[i * 2][3];
            }
            tr[i] = v;

        }
    }

    public void update(int p, int v) {
        tr[p + N] = new int[] { p - v, v - p, 1, 0 };
        int i = p + N;
        i /= 2;
        while (i > 0) {
            int[] vp = new int[4];
            vp[0] = Math.max(tr[i * 2][0], tr[i * 2 + 1][0]);
            vp[1] = Math.max(tr[i * 2][1], tr[i * 2 + 1][1]);
            vp[2] = 7;
            vp[3] = Math.max(Math.max(tr[i * 2][3], tr[i * 2 + 1][3]), tr[i * 2][0] + tr[i * 2 + 1][1]);
            if (tr[i * 2 + 1][2] == -1) {
                vp[0] = tr[i * 2][0];
                vp[1] = tr[i * 2][1];
                vp[2] = tr[i * 2][2];
                vp[3] = tr[i * 2][3];
            }
            tr[i] = vp;
            i /= 2;
        }
    }

    public int query() {

        int mx = 0;
        int l = N;
        int r = N + N - 1;
        while (l < r) {
            if (l % 2 == 1)
                mx = Math.max(mx, tr[l++][3]);
            if (r % 2 == 0)
                mx = Math.max(mx, tr[r--][3]);
            l /= 2;
            r /= 2;
        }
        if (l == r)
            mx = Math.max(tr[l][3], mx);
        return mx;
    }
}
