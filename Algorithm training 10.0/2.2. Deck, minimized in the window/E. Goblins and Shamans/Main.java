import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void check(Deque<Integer> l, Deque<Integer> r) {
        int size = l.size() + r.size();
        int needl = (size + 1) / 2;
        while (l.size() < needl) {
            l.addLast(r.pollFirst());
        }
        while (l.size() > needl) {
            r.addFirst(l.pollLast());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> l = new ArrayDeque<>();
        Deque<Integer> r = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] p = reader.readLine().split(" ");
            if (p[0].equals("+")) {
                int x = Integer.parseInt(p[1]);
                r.addLast(x);
                check(l, r);
            } else if (p[0].equals("*")) {
                int x = Integer.parseInt(p[1]);
                l.addLast(x);
                check(l, r);
            } else {
                writer.write(String.valueOf(l.pollFirst()));
                writer.newLine();
                check(l, r);
            }
        }
        reader.close();
        writer.close();
    }
}
