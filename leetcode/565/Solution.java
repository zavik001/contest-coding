// https://leetcode.com/problems/array-nesting/description/

class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = 0;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int length = 0;
                int current = i;

                while (!visited[current]) {
                    visited[current] = true;
                    current = nums[current];
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
