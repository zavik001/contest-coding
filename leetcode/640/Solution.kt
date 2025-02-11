// https://leetcode.com/problems/solve-the-equation/description/

class Solution {
    fun solveEquation(equation: String): String {
        val sides = equation.split("=")
        val left = parseEquation(sides[0])
        val right = parseEquation(sides[1])
        
        val coefficientX = left.first - right.first
        val constant = right.second - left.second
        
        return when {
            coefficientX == 0 && constant == 0 -> "Infinite solutions"
            coefficientX == 0 -> "No solution"
            else -> "x=${constant / coefficientX}"
        }
    }
    
    private fun parseEquation(expression: String): Pair<Int, Int> {
        var coefficientX = 0
        var constant = 0
        var sign = 1
        var i = 0
        
        while (i < expression.length) {
            when {
                expression[i] == '+' -> sign = 1
                expression[i] == '-' -> sign = -1
                expression[i] == 'x' -> coefficientX += sign
                else -> {
                    var j = i
                    while (j < expression.length && expression[j].isDigit()) j++
                    val num = expression.substring(i, j).toInt() * sign
                    if (j < expression.length && expression[j] == 'x') {
                        coefficientX += num
                        i = j
                    } else {
                        constant += num
                        i = j - 1
                    }
                }
            }
            i++
        }
        return Pair(coefficientX, constant)
    }
}
