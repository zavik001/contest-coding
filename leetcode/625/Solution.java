// https://leetcode.com/problems/minimum-factorization/description/

public class Solution {
    public int smallestFactorization(int num) {
        if (num == 1) return 1;
        
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        
        if (num > 1) return 0;
        
        long result = 0;
        for (int i = factors.size() - 1; i >= 0; i--) {
            result = result * 10 + factors.get(i);
            if (result > Integer.MAX_VALUE) return 0;
        }
        
        return (int) result;
    }
}
