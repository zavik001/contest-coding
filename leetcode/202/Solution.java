// https://leetcode.com/problems/happy-number/?envType=problem-list-v2&envId=hash-table

class Solution {
    static int maxCycle = 1000;
    public boolean isHappy(int n) {
        boolean flag = false;
        while(maxCycle-- > 0) {
            int newN = 0;
            while(n > 9) {
                int x = n % 10;
                newN += x * x;
                n = n / 10;
            }
            newN += n * n;
            n = newN;
            if (n == 1) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(1));
    }
}
