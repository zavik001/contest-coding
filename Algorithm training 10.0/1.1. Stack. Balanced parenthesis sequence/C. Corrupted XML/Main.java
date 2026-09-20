import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static boolean check(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '<') {
                return false;
            }
            int end = s.indexOf('>', i);
            if (end == -1) {
                return false;
            }
            String tag = s.substring(i + 1, end);
            if (tag.length() == 0) {
                return false;
            }
            if (tag.charAt(0) == '/') {
                String name = tag.substring(1);
                if (name.length() == 0) {
                    return false;
                }
                for (int j = 0; j < name.length(); j++) {
                    if (name.charAt(j) < 'a' || name.charAt(j) > 'z') {
                        return false;
                    }
                }
                if (stack.isEmpty() || !stack.peek().equals(name)) {
                    return false;
                }
                stack.pop();
            } else {
                for (int j = 0; j < tag.length(); j++) {
                    if (tag.charAt(j) < 'a' || tag.charAt(j) > 'z') {
                        return false;
                    }
                }
                stack.push(tag);
            }
            i = end + 1;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        String chars = "abcdefghijklmnopqrstuvwxyz<>/";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < chars.length(); j++) {
                char c = chars.charAt(j);
                if (c == s.charAt(i)) {
                    continue;
                }
                String newString = s.substring(0, i) +
                        c +
                        s.substring(i + 1);
                if (check(newString)) {
                    writer.write(newString);
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }
        reader.close();
        writer.close();
    }
}
