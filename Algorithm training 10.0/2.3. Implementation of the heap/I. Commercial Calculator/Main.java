import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().split(" ");
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(parts[i]));
        }
        long total = 0;
        while (queue.size() > 1) {
            long a = queue.poll();
            long b = queue.poll();
            long sum = a + b;
            total += sum;
            queue.add(sum);
        }
        writer.write(String.format("%.2f", total * 0.05));
        reader.close();
        writer.close();
    }
}
