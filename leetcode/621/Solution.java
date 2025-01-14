// https://leetcode.com/problems/task-scheduler/description/

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        int maxFreq = taskCounts.values().stream().max(Integer::compare).get();

        int countMaxFreq = (int) taskCounts.values().stream().filter(count -> count == maxFreq).count();

        int minimalIntervals = (maxFreq - 1) * (n + 1) + countMaxFreq;

        return Math.max(tasks.length, minimalIntervals);
    }
}
