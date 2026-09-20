import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static int ch(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '*') {
            return 2;
        }
        return 0;
    }

    public static boolean calc(Stack<Integer> numbers, Stack<Character> operations) {
        if (numbers.size() < 2 || operations.isEmpty()) {
            return false;
        }
        int a = numbers.pop();
        int b = numbers.pop();
        char operation = operations.pop();
        if (operation == '+') {
            numbers.push(b + a);
        } else if (operation == '-') {
            numbers.push(b - a);
        } else if (operation == '*') {
            numbers.push(b * a);
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        boolean wrong = false;
        boolean needNumber = true;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!needNumber) {
                    wrong = true;
                    break;
                }
                int number = 0;
                while (i < s.length() &&
                        s.charAt(i) >= '0' &&
                        s.charAt(i) <= '9') {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numbers.push(number);
                needNumber = false;
            } else if (c == '(') {
                if (!needNumber) {
                    wrong = true;
                    break;
                }
                operations.push(c);
                i++;
                needNumber = true;
            } else if (c == ')') {
                if (needNumber) {
                    wrong = true;
                    break;
                }
                boolean foundOpening = false;
                while (!operations.isEmpty()) {
                    if (operations.peek() == '(') {
                        operations.pop();
                        foundOpening = true;
                        break;
                    }
                    if (!calc(numbers, operations)) {
                        wrong = true;
                        break;
                    }
                }
                if (!foundOpening) {
                    wrong = true;
                    break;
                }
                i++;
                needNumber = false;
            } else if (c == '+' || c == '-' || c == '*') {
                if (needNumber) {
                    wrong = true;
                    break;
                }
                while (!operations.isEmpty() &&
                        operations.peek() != '(' &&
                     ch(operations.peek()) >= ch(c)) {
                    if (!calc(numbers, operations)) {
                        wrong = true;
                        break;
                    }
                }
                if (wrong) {
                    break;
                }
                operations.push(c);
                i++;
                needNumber = true;
            } else {
                wrong = true;
                break;
            }
        }
        if (needNumber) {
            wrong = true;
        }
        while (!wrong && !operations.isEmpty()) {
            if (operations.peek() == '(') {
                wrong = true;
                break;
            }
            if (!calc(numbers, operations)) {
                wrong = true;
            }
        }
        if (wrong || numbers.size() != 1) {
            writer.write("WRONG");
        } else {
            writer.write(String.valueOf(numbers.pop()));
        }
        reader.close();
        writer.close();
    }
}
