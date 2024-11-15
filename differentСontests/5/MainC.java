import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MainC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        findSubstring(s, t, k);
    }

    public static void findSubstring(String s, String t, int k) {
        Map<Character, Integer> goodCharMap = buildGoodCharMap(t);
        List<String> substrings = extractValidSubstrings(s, goodCharMap);

        for (int i = substrings.size() - 1; i >= 0; --i) {
            String currentString = substrings.get(i);
            if (printValidSubstring(currentString, goodCharMap, k)) {
                return;
            }
        }
        System.out.println(-1);
    }

    private static Map<Character, Integer> buildGoodCharMap(String t) {
        Map<Character, Integer> goodCharMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            goodCharMap.put(ch, goodCharMap.getOrDefault(ch, 0) + 1);
        }
        return goodCharMap;
    }

    private static List<String> extractValidSubstrings(String s, Map<Character, Integer> goodCharMap) {
        List<String> substrings = new ArrayList<>();
        StringBuilder last = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!goodCharMap.containsKey(ch)) {
                if (last.length() > 0) {
                    substrings.add(last.toString());
                }
                last = new StringBuilder();
            } else {
                last.append(ch);
            }
        }
        if (last.length() > 0) {
            substrings.add(last.toString());
        }

        return substrings;
    }

    private static boolean printValidSubstring(String s, Map<Character, Integer> goodCharMap, int k) {
        Map<Character, Integer> hasMap = new HashMap<>();
        int n = s.length();

        for (int l = n - 1; l >= 0; --l) {
            char ch = s.charAt(l);
            hasMap.put(ch, hasMap.getOrDefault(ch, 0) + 1);

            if (l + k <= n - 1) {
                char removeChar = s.charAt(l + k);
                hasMap.put(removeChar, hasMap.get(removeChar) - 1);
                if (hasMap.get(removeChar) == 0) {
                    hasMap.remove(removeChar);
                }
            }

            if (hasMap.size() == goodCharMap.size()) {
                for (int j = l; j < Math.min(l + k, n); ++j) {
                    System.out.print(s.charAt(j));
                }
                System.out.println();
                return true;
            }
        }
        return false;
    }
}
