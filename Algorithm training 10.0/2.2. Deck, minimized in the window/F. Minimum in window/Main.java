import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] first = reader.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        int[] a = new int[n];
        int count = 0;
        while (count < n) {
            String[] p = reader.readLine().split(" ");
            for (int i = 0; i < p.length && count < n; i++) {
                a[count++] = Integer.parseInt(p[i]);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && a[deque.peekLast()] >= a[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                writer.write(String.valueOf(a[deque.peekFirst()]));
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
    }
}
