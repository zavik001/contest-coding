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
        int n = Integer.parseInt(reader.readLine());
        String w = reader.readLine();
        String s = reader.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return;
                }
                char top = stack.peek();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[')) {
                    return;
                }
                stack.pop();
            }
        }
        while (ans.length() < n) {
            for (int j = 0; j < 4; j++) {
                char c = w.charAt(j);
                boolean possible = false;
                if (c == '(' || c == '[') {
                    int newDepth = stack.size() + 1;
                    int remaining = n - ans.length() - 1;
                    if (remaining >= newDepth &&
                            (remaining - newDepth) % 2 == 0) {
                        possible = true;
                    }
                } else {
                    if (!stack.isEmpty()) {
                        char top = stack.peek();
                        if ((c == ')' && top == '(') ||
                                (c == ']' && top == '[')) {
                            int newDepth = stack.size() - 1;
                            int remaining = n - ans.length() - 1;
                            if (remaining >= newDepth &&
                                    (remaining - newDepth) % 2 == 0) {
                                possible = true;
                            }
                        }
                    }
                }
                if (possible) {
                    ans.append(c);

                    if (c == '(' || c == '[') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }

                    break;
                }
            }
        }
        writer.write(ans.toString());
        reader.close();
        writer.close();
    }
}
