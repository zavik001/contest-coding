import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            writer.write("0");
            writer.newLine();
            writer.write("0");
        } else {
            String[] parts = reader.readLine().split(" ");
            int x = Integer.parseInt(reader.readLine());
            int less = 0;
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(parts[i]);
                if (a < x) {
                    less++;
                }
            }
            writer.write(String.valueOf(less));
            writer.newLine();
            writer.write(String.valueOf(n - less));
        }
        reader.close();
        writer.close();
    }
}
