import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] p = reader.readLine().split(" ");
        int n = Integer.parseInt(p[0]);
        long[] h = new long[n + 1];
        for (int i = 0; i < n; i++) {
            h[i] = Long.parseLong(p[i + 1]);
        }
        h[n] = 0;
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                int index = stack.pop();
                long height = h[index];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        writer.write(String.valueOf(ans));
        reader.close();
        writer.close();
    }
}
