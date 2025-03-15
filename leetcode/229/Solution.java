// https://leetcode.com/problems/majority-element-ii/?envType=problem-list-v2&envId=hash-table

import java.util.Map;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i ++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            } else {
                m.put(nums[i], 1);
            }
        }

        return m.entrySet().stream().filter(entry -> entry.getValue() > n / 3).map(entry -> entry.getKey()).toList();
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
}