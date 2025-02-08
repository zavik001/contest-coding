// https://leetcode.com/problems/string-without-aaa-or-bbb/description/?envType=problem-list-v2&envId=string&difficulty=MEDIUM

class Solution {
    fun strWithout3a3b(a: Int, b: Int): String {
        val sb = StringBuilder();
        var countA = a
        var countB = b

        while (countA > 0 || countB > 0) {
            val writeA = if (sb.length >= 2 && sb.takeLast(2) == "aa") false
                         else if (sb.length >= 2 && sb.takeLast(2) == "bb") true
                         else if (countA >= countB) true
                         else false
            
            if (writeA) {
                sb.append('a')
                countA--
            } else {
                sb.append('b')
                countB--
            }
        }

        return sb.toString()
    }
}
