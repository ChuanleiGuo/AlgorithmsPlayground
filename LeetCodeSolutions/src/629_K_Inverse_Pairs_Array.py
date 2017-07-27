class Solution(object):
    def kInversePairs(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        mod = 10 ** 9 + 7
        if k > n * (n - 1) / 2 or k < 0:
            return 0
        if k == 0 or k == n * (n - 1) / 2:
            return 1
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        dp[2][0] = 1
        dp[2][1] = 1
        for i in range(3, n + 1):
            dp[i][0] = 1
            for j in range(1, min(k, i * (i - 1) / 2) + 1):
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
                if j >= i:
                    dp[i][j] -= dp[i - 1][j - i]
                dp[i][j] = (dp[i][j] + mod) % mod
        return dp[n][k]