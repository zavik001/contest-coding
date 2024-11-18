import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MainA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        
        String mostString = "";
        int maxCount = 0;
        
        for (int i = 0; i < n; i++) {
            String currentString = in.nextLine();
            int uniqueCount = countUniqueCharacters(currentString);
            
            if (uniqueCount > maxCount) {
                maxCount = uniqueCount;
                mostString = currentString;
            }
        }
        
        in.close();
        
        System.out.println(maxCount + " " + mostString);
    }
    
    private static int countUniqueCharacters(String s) {
        Set<Character> uniqueCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueCharacters.add(c);
        }
        return uniqueCharacters.size();
    }
}
