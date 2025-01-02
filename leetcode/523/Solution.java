// https://leetcode.com/problems/continuous-subarray-sum/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> modSet = new HashSet<>();
        int prefixSum = 0, prevMod = 0;

        for (int num : nums) {
            prefixSum += num;
            int currentMod = prefixSum % k;

            if (modSet.contains(currentMod)) {
                return true;
            }

            modSet.add(prevMod);
            prevMod = currentMod;
        }

        return false;
    }
}
