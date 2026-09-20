import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static int ch(char c) {
        if (c == '!') {
            return 3;
        }
        if (c == '&') {
            return 2;
        }
        if (c == '|' || c == '^') {
            return 1;
        }
        return 0;
    }

    public static boolean calc(Stack<Integer> numbers, Stack<Character> operations) {
        if (numbers.isEmpty() || operations.isEmpty()) {
            return false;
        }
        char operation = operations.pop();
        if (operation == '!') {
            int a = numbers.pop();
            numbers.push(a == 0 ? 1 : 0);
        } else {
            if (numbers.size() < 2) {
                return false;
            }
            int a = numbers.pop();
            int b = numbers.pop();
            if (operation == '&') {
                numbers.push(b & a);
            } else if (operation == '|') {
                numbers.push(b | a);
            } else if (operation == '^') {
                numbers.push(b ^ a);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '0' || c == '1') {
                numbers.push(c - '0');
            } else if (c == '(') {
                operations.push(c);
            } else if (c == ')') {
                while (!operations.isEmpty() && operations.peek() != '(') {
                    calc(numbers, operations);
                }
                operations.pop();
            } else if (c == '!') {
                operations.push(c);
            } else if (c == '&' || c == '|' || c == '^') {
                while (!operations.isEmpty() &&
                        operations.peek() != '(' &&
                        ch(operations.peek()) >= ch(c)) {

                    calc(numbers, operations);
                }
                operations.push(c);
            }
        }
        while (!operations.isEmpty()) {
            calc(numbers, operations);
        }
        writer.write(String.valueOf(numbers.pop()));
        reader.close();
        writer.close();
    }
}
