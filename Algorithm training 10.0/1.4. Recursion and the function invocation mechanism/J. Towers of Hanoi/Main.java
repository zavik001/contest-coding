import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static BufferedWriter writer;

    public static void move(int n, int x, int y) throws IOException {
        if (n == 0) {
            return;
        }
        int z = 6 - x - y;
        move(n - 1, x, z);
        writer.write(n + " " + x + " " + y);
        writer.newLine();
        move(n - 1, z, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        move(n, 1, 3);
        reader.close();
        writer.close();
    }
}
