import java.util.Scanner;
import java.util.function.Consumer;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class MatrixPalindrome {
    public static final Scanner in = new Scanner(System.in);
    public static final Consumer<String> out = System.out::println;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Pos))
                return false;
            Pos p = (Pos) o;
            return r == p.r && c == p.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        long ans = 0;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = 0; j <= (m - 1) / 2; j++) {
                Set<Pos> positions = new HashSet<>();
                positions.add(new Pos(i, j));
                positions.add(new Pos(i, m - 1 - j));
                positions.add(new Pos(n - 1 - i, j));
                positions.add(new Pos(n - 1 - i, m - 1 - j));

                Map<Integer, Integer> freq = new HashMap<>();
                for (Pos p : positions) {
                    int val = mat[p.r][p.c];
                    freq.put(val, freq.getOrDefault(val, 0) + 1);
                }

                int maxFreq = 0;
                for (int f : freq.values()) {
                    maxFreq = Math.max(maxFreq, f);
                }
                ans += positions.size() - maxFreq;
            }
        }

        out.accept(String.valueOf(ans));
    }
}
