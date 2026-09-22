import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int n;
    static long swaps;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine().trim());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        swaps = 0;
        for (int i = n - 1; i >= 0; i--) {
            down(i);
        }
        writer.write(String.valueOf(swaps));
        writer.newLine();
        reader.close();
        writer.close();
    }

    static void down(int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && a[left] > a[largest]) {
                largest = left;
            }
            if (right < n && a[right] > a[largest]) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            swaps++;
            i = largest;
        }
    }
}
