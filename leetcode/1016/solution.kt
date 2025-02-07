// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/?envType=problem-list-v2&envId=string&difficulty=MEDIUM

class Solution {
    fun queryString(s: String, n: Int): Boolean {
        for (i in 1..n) {
            val binary = Integer.toBinaryString(i)
            if (!s.contains(binary)) {
                return false
            }
        }
        return true
    }
}
