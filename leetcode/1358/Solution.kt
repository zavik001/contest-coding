// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/?envType=problem-list-v2&envId=string&difficulty=MEDIUMclass 

Solution {
    fun numberOfSubstrings(s: String): Int {
        val n = s.length
        var count = 0
        val freq = IntArray(3)
        var left = 0

        for (right in 0 until n) {
            freq[s[right] - 'a']++

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - right
                freq[s[left] - 'a']--
                left++
            }
        }

        return count
    }
}
