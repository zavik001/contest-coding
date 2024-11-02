import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> compress(List<String> lst) {
        List<String> ans = new ArrayList<>();
        ans.add(lst.get(0));
        
        for (int i = 1; i < lst.size(); i++) {
            String now = lst.get(i);
            if (!now.equals(ans.get(ans.size() - 1))) {
                ans.add(now);
            }
        }
        
        if (ans.size() > 1 && ans.get(0).chars().allMatch(c -> c == '.')) {
            ans.remove(0);
        }
        if (ans.size() > 1 && ans.get(ans.size() - 1).chars().allMatch(c -> c == '.')) {
            ans.remove(ans.size() - 1);
        }
        
        return ans;
    }

    public static List<String> invert(List<String> lst) {
        List<StringBuilder> ans = new ArrayList<>();
        int rowLength = lst.get(0).length();

        for (int i = 0; i < rowLength; i++) {
            ans.add(new StringBuilder());
        }
        
        for (String now : lst) {
            for (int i = 0; i < now.length(); i++) {
                ans.get(i).append(now.charAt(i));
            }
        }
        
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : ans) {
            result.add(sb.toString());
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(scanner.nextLine());
        }

        a = compress(a);
        a = invert(a);
        a = compress(a);
        a = invert(a);

        if (a.equals(List.of("#"))) {
            System.out.println("I");
        } else if (a.equals(List.of("###", "#.#", "###"))) {
            System.out.println("O");
        } else if (a.equals(List.of("##", "#.", "##"))) {
            System.out.println("C");
        } else if (a.equals(List.of("#.", "##"))) {
            System.out.println("L");
        } else if (a.equals(List.of("#.#", "###", "#.#"))) {
            System.out.println("H");
        } else if (a.equals(List.of("###", "#.#", "###", "#.."))) {
            System.out.println("P");
        } else {
            System.out.println("X");
        }
        
        scanner.close();
    }
}
