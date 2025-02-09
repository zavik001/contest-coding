// https://leetcode.com/problems/groups-of-special-equivalent-strings/description/?envType=problem-list-v2&envId=string&difficulty=MEDIUM

class Solution {
    fun numSpecialEquivGroups(words: Array<String>): Int {
        val groups = mutableSetOf<String>()

        for (word in words) {
            val evenChars = mutableListOf<Char>()
            val oddChars = mutableListOf<Char>()

            for (i in word.indices) {
                if (i % 2 == 0) {
                    evenChars.add(word[i])
                } else {
                    oddChars.add(word[i])
                }
            }

            evenChars.sort()
            oddChars.sort()

            val key = evenChars.joinToString("") + "|" + oddChars.joinToString("")

            groups.add(key)
        }

        return groups.size
    }
}
