// https://leetcode.com/problems/word-subsets/description/?envType=problem-list-v2&envId=string&difficulty=MEDIUM

class Solution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val answer = mutableListOf<String>()
        val maxCountLetters = IntArray(26)

        for (word in words2) {
            val currentWord = IntArray(26)
            for (letter in word) {
                currentWord[letter - 'a']++
            }

            for (i in 0..25) {
                if (maxCountLetters[i] < currentWord[i]) {
                    maxCountLetters[i] = currentWord[i]
                }
            }
        }

        for (word in words1) {
            val currentWord = IntArray(26)
            for (letter in word) {
                currentWord[letter - 'a']++
            }

            var flag = true
            for (i in 0..25) {
                if (currentWord[i] < maxCountLetters[i]) {
                    flag = false
                }
            }

            if (flag == true) {
                answer.add(word)
            }
        }

        return answer
    }
}