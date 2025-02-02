// https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maLen = 1;
        int currentLen = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maLen = Math.max(maLen, currentLen);
        }
        
        return maLen;
    }
}
