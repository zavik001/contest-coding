import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] heap;
    static int size = 0;

    public static void insert(int x) {
        heap[size] = x;
        int current = size;
        size++;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[parent] >= heap[current]) {
                break;
            }
            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;
            current = parent;
        }
    }

    public static int extract() {
        int result = heap[0];
        size--;
        heap[0] = heap[size];
        int current = 0;
        while (true) {
            int left = current * 2 + 1;
            int right = current * 2 + 2;
            if (left >= size) {
                break;
            }
            int largest = left;
            if (right < size && heap[right] > heap[left]) {
                largest = right;
            }
            if (heap[current] >= heap[largest]) {
                break;
            }
            int temp = heap[current];
            heap[current] = heap[largest];
            heap[largest] = temp;
            current = largest;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        heap = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int command = Integer.parseInt(parts[0]);
            if (command == 0) {
                int x = Integer.parseInt(parts[1]);
                insert(x);
            } else {
                writer.write(String.valueOf(extract()));
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
    }
}
