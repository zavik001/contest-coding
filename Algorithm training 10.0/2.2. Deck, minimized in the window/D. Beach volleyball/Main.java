import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] p = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(p[i]);
        }
        int[][] matches = new int[n - 1][2];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            queue.add(a[i]);
        }
        int current = a[0];
        for (int i = 0; i < n - 1; i++) {
            int next = queue.poll();
            matches[i][0] = current;
            matches[i][1] = next;
            if (current > next) {
                queue.add(next);
            } else {
                queue.add(current);
                current = next;
            }
        }
        int[] cycle = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            cycle[i] = queue.poll();
        }
        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            long k = Long.parseLong(reader.readLine());
            if (k <= n - 1) {
                writer.write(matches[(int) k - 1][0] + " " + matches[(int) k - 1][1]);
            } else {
                int index = (int) ((k - n) % (n - 1));
                writer.write(current + " " + cycle[index]);
            }
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
