// https://leetcode.com/problems/course-schedule-iii/

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int currentTime = 0;
        
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            
            currentTime += duration;
            maxHeap.offer(duration);
            
            if (currentTime > lastDay) {
                currentTime -= maxHeap.poll();
            }
        }
        
        return maxHeap.size();
    }
}
