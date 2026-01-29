import java.util.*;

public class MainC {

    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (size[a] < size[b]) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DSU dsu = new DSU(n);
        sc.nextLine();

        List<Set<String>> queries = new ArrayList<>();
        Map<String, List<Integer>> wordToQueries = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine().trim());
            String[] words = sc.nextLine().trim().split(" ");
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            queries.add(uniqueWords);

            for (String w : uniqueWords) {
                wordToQueries.computeIfAbsent(w, k -> new ArrayList<>()).add(i);
            }
        }

        for (List<Integer> indices : wordToQueries.values()) {
            for (int j = 1; j < indices.size(); j++) {
                dsu.union(indices.get(0), indices.get(j));
            }
        }

        Map<Integer, Set<String>> components = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            components.computeIfAbsent(root, k -> new HashSet<>()).addAll(queries.get(i));
        }

        int numContexts = components.size();
        int maxSize = 0;
        for (Set<String> s : components.values()) {
            maxSize = Math.max(maxSize, s.size());
        }

        System.out.println(numContexts + " " + maxSize);
    }
}
