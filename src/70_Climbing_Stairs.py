class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        dp = [0] * n
        dp[0] = 1
        for i in range(1, n):
            if i == 1:
                dp[i] = dp[0] + 1
            else:
                dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n - 1]
