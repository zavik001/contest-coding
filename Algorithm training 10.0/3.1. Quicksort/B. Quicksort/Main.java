import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    static Random rnd = new Random();

    static int partition(int[] a, int left, int right) {
        int pivotIndex = left + rnd.nextInt(right - left + 1);
        swap(a, pivotIndex, right);
        int pivot = a[right];
        int i = left - 1;
        int j = right;
        while (true) {
            do {
                i++;
            } while (a[i] < pivot);
            do {
                j--;
            } while (j >= left && a[j] > pivot);
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, i, right);
        return i;
    }

    static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int p = partition(a, left, right);
        quickSort(a, left, p - 1);
        quickSort(a, p + 1, right);
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i > 0)
                writer.write(' ');
            writer.write(String.valueOf(a[i]));
        }
        writer.newLine();
        reader.close();
        writer.close();
    }
}
