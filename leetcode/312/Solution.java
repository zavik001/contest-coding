// https://leetcode.com/problems/burst-balloons/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        
        return maxCoinsDP(dp, newNums, 1, n);
    }
    
    private int maxCoinsDP(int[][] dp, int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        
        int maxCoins = 0;
        
        for (int i = left; i <= right; i++) {
            int coins = nums[left - 1] * nums[i] * nums[right + 1]
                      + maxCoinsDP(dp, nums, left, i - 1)
                      + maxCoinsDP(dp, nums, i + 1, right);
            
            maxCoins = Math.max(maxCoins, coins);
        }
        
        dp[left][right] = maxCoins;
        return maxCoins;
    }
}
