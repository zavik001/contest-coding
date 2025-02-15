// https://leetcode.com/problems/minimum-absolute-difference/description/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDif = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) < minDif) {
                minDif = Math.abs(arr[i] - arr[i - 1]);
            }
        }

        List<List<Integer>> pair = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == minDif) {
                pair.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
            }
        }

        return pair;
    }
}

