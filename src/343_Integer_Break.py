class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0] * (n + 1)
        dp[1] = 1
        for i in range(2, n + 1):
            j = 1
            while (j << 1) <= i:
                dp[i] = max(dp[i], (max(j, dp[j]) * max(i - j, dp[i - j])))
                j += 1
        return dp[n]
