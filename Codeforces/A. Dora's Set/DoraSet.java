import java.util.Scanner;

public class DoraSet {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            
            System.out.println(maxOperations(l, r));
        }
        
        scanner.close();
    }
    
    private static int maxOperations(int l, int r) {
        int rangeSize = r - l + 1;
        if (rangeSize < 3) {
            return 0;
        }
        
        // Theoretical max operations based on combinatorial limits
        return rangeSize / 3;
    }
}
