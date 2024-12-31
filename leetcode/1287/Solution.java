https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

// Можно было решить без HashMap, но суть была в том, чтобы освежить память по HashMap и в целом по коллекциям,  а так тут сложность O(N).

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int num = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                num = entry.getKey();
            }
        }

        return num;
    }
}