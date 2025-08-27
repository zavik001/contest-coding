import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainA {
    private static final Consumer<String> printLine = System.out::println;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String num = input.nextLine();
        String[] digits = num.split("");
        Arrays.sort(digits);
        if (digits[0].equals("0")) {
            for (int i = 1; i < digits.length; i++) {
                if (!digits[i].equals("0")) {
                    digits[0] = digits[i];
                    digits[i] = "0";
                    break;
                }
            }
        }
        printLine.accept(String.join("", digits));
    }
}
