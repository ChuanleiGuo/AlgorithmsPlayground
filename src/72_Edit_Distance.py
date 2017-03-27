class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        row = len(word1) + 1
        col = len(word2) + 1

        dp = [[0] * col for _ in range(row)]

        for i in range(col):
            dp[0][i] = i

        for i in range(row):
            dp[i][0] = i

        for i in range(1, row):
            for j in range(1, col):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                dp[i][j] = min(dp[i][j], dp[i - 1][j] + 1, dp[i][j - 1] + 1)

        return dp[row - 1][col - 1]
