// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }

        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            int val = curr[0], listIndex = curr[1], elementIndex = curr[2];

            if (max - val < end - start) {
                start = val;
                end = max;
            }

            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                max = Math.max(max, nextVal);
            }
        }

        return new int[]{start, end};
    }
}
