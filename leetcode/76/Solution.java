// https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=hash-table

public class Solution {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        int[] need = new int[128];
        for (char c : t.toCharArray())
            need[c]++;
        int[] window = new int[128];
        int left = 0, right = 0, count = 0, minLen = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (window[c] <= need[c])
                count++;
            right++;
            while (count == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                if (window[d] == need[d])
                    count--;
                window[d]--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
