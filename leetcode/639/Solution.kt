// https://leetcode.com/problems/decode-ways-ii/description/

class Solution {
    fun numDecodings(s: String): Int {
        val MOD = 1_000_000_007
        val n = s.length
        if (n == 0) return 0

        val dp = LongArray(n + 1)
        dp[0] = 1

        for (i in 1..n) {
            when (s[i - 1]) {
                '*' -> dp[i] += 9 * dp[i - 1]
                in '1'..'9' -> dp[i] += dp[i - 1]
            }

            if (i >= 2) {
                when (s[i - 2]) {
                    '*' -> {
                        when (s[i - 1]) {
                            '*' -> dp[i] += 15 * dp[i - 2]
                            in '0'..'6' -> dp[i] += 2 * dp[i - 2]
                            else -> dp[i] += dp[i - 2]
                        }
                    }
                    '1' -> {
                        when (s[i - 1]) {
                            '*' -> dp[i] += 9 * dp[i - 2]
                            else -> dp[i] += dp[i - 2]
                        }
                    }
                    '2' -> {
                        when (s[i - 1]) {
                            '*' -> dp[i] += 6 * dp[i - 2]
                            in '0'..'6' -> dp[i] += dp[i - 2]
                        }
                    }
                }
            }

            dp[i] = dp[i] % MOD
        }

        return dp[n].toInt()
    }
}
