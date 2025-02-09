// https://leetcode.com/problems/palindromic-substrings/?envType=problem-list-v2&envId=string&difficulty=MEDIUM

class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        var count = 0

        fun expandAroundCenter(left: Int, right: Int): Int {
            var l = left
            var r = right
            var cnt = 0
            while (l >= 0 && r < n && s[l] == s[r]) {
                cnt++
                l--
                r++
            }
            return cnt
        }

        for (i in 0 until n) {
            count += expandAroundCenter(i, i)
            count += expandAroundCenter(i, i + 1)
        }

        return count
    }
}
