import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(reader.readLine());
        if (count == 0) {
            reader.close();
            writer.close();
            return;
        }
        String[] parts = reader.readLine().split(" ");
        TreeSet<Integer> set = new TreeSet<>();
        int median = 0;
        for (int i = 0; i < count; i++) {
            int x = Integer.parseInt(parts[i]);
            set.add(x);
            if (i == 0) {
                median = x;
            } else if ((i + 1) % 2 == 0) {
                if (x < median) {
                    median = set.lower(median);
                }
            } else {
                if (x > median) {
                    median = set.higher(median);
                }
            }
            if (i > 0) {
                writer.write(" ");
            }
            writer.write(String.valueOf(median));
        }
        reader.close();
        writer.close();
    }
}
