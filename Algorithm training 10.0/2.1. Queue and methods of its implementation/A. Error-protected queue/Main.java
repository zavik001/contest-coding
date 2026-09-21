import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit")) {
                writer.write("bye");
                writer.newLine();
                break;
            }
            if (s.startsWith("push")) {
                int value = Integer.parseInt(s.substring(5));
                queue.add(value);
                writer.write("ok");
                writer.newLine();
            } else if (s.equals("pop")) {
                if (queue.isEmpty()) {
                    writer.write("error");
                } else {
                    writer.write(String.valueOf(queue.poll()));
                }
                writer.newLine();
            } else if (s.equals("front")) {
                if (queue.isEmpty()) {
                    writer.write("error");
                } else {
                    writer.write(String.valueOf(queue.peek()));
                }
                writer.newLine();
            } else if (s.equals("size")) {
                writer.write(String.valueOf(queue.size()));
                writer.newLine();
            } else if (s.equals("clear")) {
                queue.clear();
                writer.write("ok");
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
    }
}
