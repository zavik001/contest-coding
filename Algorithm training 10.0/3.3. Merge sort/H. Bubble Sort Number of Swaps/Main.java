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
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long swaps = countInversions(a, 0, n - 1);
        writer.write(String.valueOf(swaps));
        writer.newLine();
        reader.close();
        writer.close();
    }

    private static long countInversions(int[] a, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        long inv = countInversions(a, left, mid);
        inv += countInversions(a, mid + 1, right);
        inv += mergeAndCount(a, left, mid, right);
        return inv;
    }

    private static long mergeAndCount(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = a[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[mid + 1 + j];
        long inv = 0;
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                inv += (n1 - i);
                a[k++] = R[j++];
            }
        }
        while (i < n1)
            a[k++] = L[i++];
        while (j < n2)
            a[k++] = R[j++];
        return inv;
    }
}
