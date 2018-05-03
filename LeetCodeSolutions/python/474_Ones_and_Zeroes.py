class Solution(object):
    def findMaxForm(self, strs, m, n):
        """
        :type strs: List[str]
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        def counts(s):
            return sum(1 for c in s if c == '0'), \
                   sum(1 for c in s if c == '1')

        for num_zero, num_one in [counts(s) for s in strs]:
            for i in range(m, -1, -1):
                for j in range(n, -1, -1):
                    if i >= num_zero and j >= num_one:
                        dp[i][j] = max(dp[i][j], dp[i - num_zero][j - num_one] + 1)

        return dp[m][n]
