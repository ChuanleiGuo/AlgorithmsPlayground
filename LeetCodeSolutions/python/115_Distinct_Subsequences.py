class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        l_s = len(s)
        l_t = len(t)
        dp = [[0] * (l_t + 1) for _ in range(l_s + 1)]
        for i in range(l_s + 1):
            dp[i][0] = 1
        for i in range(1, l_s + 1):
            for j in range(1, l_t + 1):
                if s[i - 1] == t[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j]
        return dp[l_s][l_t]
