import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        List<int[]> numbers = parseRanges(s);
        printRanges(numbers);
    }

    public static List<int[]> parseRanges(String s) {
        s = s + ",";
        List<int[]> numbers = new ArrayList<>();
        int last = 0;
        int now = 0;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ',') {
                if (last == 0) {
                    numbers.add(new int[]{now, now});
                } else {
                    numbers.add(new int[]{last, now});
                }
                last = 0;
                now = 0;
            } else if (ch == '-') {
                last = now;
                now = 0;
            } else {
                now = now * 10 + (ch - '0');
            }
        }

        return numbers;
    }

    public static void printRanges(List<int[]> numbers) {
        for (int[] range : numbers) {
            for (int x = range[0]; x <= range[1]; ++x) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
}
