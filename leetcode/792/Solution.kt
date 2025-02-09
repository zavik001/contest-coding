// https://leetcode.com/problems/number-of-matching-subsequences/description/

class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        var answer = 0

        for (word in words) {
            var i = 0
            var j = 0

            while (j < word.length && i < s.length) {
                if (s[i] == word[j]) {
                    j++
                }
                i++
            }

            if (j == word.length) {
                answer++
            }
        }
        return answer
    }
}
