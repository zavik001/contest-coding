// https://leetcode.com/problems/longest-uncommon-subsequence-i/

class Solution {
    public int findLUSlength(String a, String b) {
        if (!a.equals(b)) {
            return Math.max(a.length(), b.length());
        } else {
            return -1;
        }
    }
}