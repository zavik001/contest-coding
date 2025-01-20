// https://leetcode.com/problems/number-of-segments-in-a-string/

class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        int segmentCount = 0;
        boolean inSegment = false;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (!inSegment) {
                    segmentCount++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }
        
        return segmentCount;
    }
}