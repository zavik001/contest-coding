import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            reader.readLine();
        }
        int m = Integer.parseInt(reader.readLine().trim());
        int[] b = new int[m];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] res = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }
        while (i < n) {
            res[k++] = a[i++];
        }
        while (j < m) {
            res[k++] = b[j++];
        }
        for (int t = 0; t < res.length; t++) {
            if (t > 0)
                writer.write(' ');
            writer.write(String.valueOf(res[t]));
        }
        writer.newLine();
        reader.close();
        writer.close();
    }
}
