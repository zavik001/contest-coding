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
        String s = reader.readLine();
        Stack<Integer> stack = new Stack<>();
        String[] ss = s.trim().split(" ");
        for (int i = 0; i < ss.length; i++) {
            String tec = ss[i];
            if (tec.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if (tec.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (tec.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else {
                stack.push(Integer.parseInt(tec));
            }
        }
        writer.write(String.valueOf(stack.pop()));
        reader.close();
        writer.close();
    }
}
