import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine().trim());
        int[] rows = new int[n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            rows[i] = Integer.parseInt(st.nextToken());
            cols[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rows);
        long V = 0;
        for (int i = 0; i < n; i++) {
            V += Math.abs(rows[i] - (i + 1));
        }
        long ans = Long.MAX_VALUE;
        for (int c = 1; c <= n; c++) {
            long H = 0;
            for (int col : cols) {
                H += Math.abs(col - c);
            }
            ans = Math.min(ans, V + H);
        }
        writer.write(String.valueOf(ans));
        writer.newLine();
        reader.close();
        writer.close();
    }
}
