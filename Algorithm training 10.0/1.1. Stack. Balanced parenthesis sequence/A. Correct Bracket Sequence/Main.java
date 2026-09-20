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
        Stack<Character> stack = new Stack<>();
        boolean ans = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    ans = false;
                    break;
                }
                char tec = stack.pop();
                if (c == ')' && tec != '(' ||
                        c == ']' && tec != '[' ||
                        c == '}' && tec != '{') {
                    ans = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            ans = false;
        }
        writer.write(ans ? "yes" : "no");
        reader.close();
        writer.close();
    }
}
