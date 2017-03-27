class Solution(object):
    dp = [0]

    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0:
            return 0
        while len(self.dp) <= n:
            m = len(self.dp)
            cnt = 2 ** 31 - 1

            i = 1
            while i * i <= m:
                cnt = min(cnt, self.dp[m - i * i] + 1)
                i += 1

            self.dp.append(cnt)

        return self.dp[n]
