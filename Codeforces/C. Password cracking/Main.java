import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt();
            String password = guessPassword(n, scanner);
            System.out.println("! " + password);
            System.out.flush();
        }
    }

    public static String guessPassword(int n, Scanner scanner) {
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            // Пробуем добавить "0" справа
            if (tryAddCharacter(password.toString() + "0", scanner)) {
                password.append("0");
            } else {
                // Если "0" не подошел, добавляем "1"
                password.append("1");
            }
        }

        return password.toString();
    }

    public static boolean tryAddCharacter(String query, Scanner scanner) {
        System.out.println("? " + query);
        System.out.flush();
        int response = scanner.nextInt();
        return response == 1;
    }
}
