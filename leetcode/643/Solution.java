// https://leetcode.com/problems/maximum-average-subarray-i/description/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sumMax = 0;
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            sumMax += nums[i];
            currentSum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            currentSum -= nums[i - k];
            currentSum += nums[i];
            if (sumMax < currentSum) {
                sumMax = currentSum;
            }
        }

        return sumMax / k;
    }
} 
