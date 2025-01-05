// // https://codeforces.com/contest/2057/problem/E1

// import java.util.*;

// public class Main {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int tt = scanner.nextInt();
//         while (tt-- > 0) {
//             solve(scanner);
//         }
//     }

//     private static void solve(Scanner scanner) {
//         int n = scanner.nextInt();
//         int m = scanner.nextInt();
//         int q = scanner.nextInt();

//         List<List<Pair>> adj = new ArrayList<>();
//         List<Integer> e = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < m; i++) {
//             int v = scanner.nextInt() - 1;
//             int u = scanner.nextInt() - 1;
//             int w = scanner.nextInt();
//             adj.get(v).add(new Pair(u, w));
//             adj.get(u).add(new Pair(v, w));
//             e.add(w);
//         }

//         Collections.sort(e);
//         e = new ArrayList<>(new HashSet<>(e));
//         Collections.sort(e);
//         m = e.size();

//         List<List<Query>> que = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             que.add(new ArrayList<>());
//         }

//         int[] low = new int[q];
//         int[] high = new int[q];
//         Arrays.fill(high, m);

//         for (int i = 0; i < q; i++) {
//             int v = scanner.nextInt() - 1;
//             int u = scanner.nextInt() - 1;
//             int k = scanner.nextInt();
//             que.get(v).add(new Query(u, k, i));
//         }

//         List<List<Query>> Q = new ArrayList<>();
//         for (int i = 0; i < m; i++) {
//             Q.add(new ArrayList<>());
//         }

//         for (int i = 0; i < n; i++) {
//             for (Query query : que.get(i)) {
//                 Q.get((low[query.idx] + high[query.idx]) / 2).add(query);
//             }

//             boolean updated = true;
//             while (updated) {
//                 updated = false;
//                 for (int j = 0; j < m; j++) {
//                     if (Q.get(j).isEmpty()) continue;

//                     int[] d = bfs(n, adj, i, e.get(j));
//                     for (Query query : Q.get(j)) {
//                         int v = query.u;
//                         int k = query.k;
//                         int idx = query.idx;
//                         if (d[v] < k) {
//                             high[idx] = j;
//                         } else {
//                             low[idx] = j;
//                         }
//                         if (low[idx] < high[idx] - 1) {
//                             updated = true;
//                             Q.get((low[idx] + high[idx]) / 2).add(query);
//                         }
//                     }
//                     Q.get(j).clear();
//                 }
//             }
//         }

//         int[] results = new int[q];
//         for (int i = 0; i < q; i++) {
//             results[i] = e.get(high[i]);
//         }
//         for (int i = 0; i < q; i++) {
//             System.out.print(results[i] + (i == q - 1 ? "\n" : " "));
//         }
//     }

//     private static int[] bfs(int n, List<List<Pair>> adj, int s, int W) {
//         int[] d = new int[n];
//         Arrays.fill(d, 2 * n);
//         Deque<Integer> q = new ArrayDeque<>();
//         d[s] = 0;
//         q.addLast(s);

//         while (!q.isEmpty()) {
//             int v = q.pollFirst();
//             for (Pair pair : adj.get(v)) {
//                 int u = pair.u;
//                 int w = pair.w;
//                 int p = w > W ? 1 : 0;
//                 if (d[v] + p < d[u]) {
//                     d[u] = d[v] + p;
//                     if (p == 1) {
//                         q.addLast(u);
//                     } else {
//                         q.addFirst(u);
//                     }
//                 }
//             }
//         }
//         return d;
//     }

//     static class Pair {
//         int u, w;

//         Pair(int u, int w) {
//             this.u = u;
//             this.w = w;
//         }
//     }

//     static class Query {
//         int u, k, idx;

//         Query(int u, int k, int idx) {
//             this.u = u;
//             this.k = k;
//             this.idx = idx;
//         }
//     }
// }
