import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class MainE {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, q;
    static char[][] field;
    static int[][] shipId;
    static Map<Integer, Integer> shipCells;
    static Map<Integer, Integer> destroyedCells;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        in.nextLine();

        field = new char[n][m];
        for (int i = 0; i < n; i++) {
            field[i] = in.nextLine().toCharArray();
        }

        shipId = new int[n][m];
        shipCells = new HashMap<>();
        destroyedCells = new HashMap<>();

        int id = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 'X' && shipId[i][j] == 0) {
                    int size = dfs(i, j, id);
                    shipCells.put(id, size);
                    destroyedCells.put(id, 0);
                    id++;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;

            if (field[x][y] == '.') {
                System.out.println("MISS");
            } else {
                int sid = shipId[x][y];
                destroyedCells.put(sid, destroyedCells.get(sid) + 1);

                if (destroyedCells.get(sid).equals(shipCells.get(sid))) {
                    System.out.println("DESTROY");
                } else {
                    System.out.println("HIT");
                }

                field[x][y] = '.';
            }
        }

        in.close();
    }

    static int dfs(int x, int y, int id) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        shipId[x][y] = id;
        int size = 0;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int cx = cell[0], cy = cell[1];
            size++;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 'X' && shipId[nx][ny] == 0) {
                    shipId[nx][ny] = id;
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        return size;
    }
}
