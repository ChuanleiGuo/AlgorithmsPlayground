class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        m, n = len(s1), len(s2)
        if m + n != len(s3):
            return False

        dp = [[False] * (n + 1) for _ in range(m + 1)]
        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 and j == 0:
                    dp[i][j] = True
                elif i == 0:
                    dp[i][j] = dp[i][j - 1] & (s2[j - 1] == s3[i + j - 1])
                elif j == 0:
                    dp[i][j] = dp[i - 1][j] & (s1[i - 1] == s3[i + j - 1])
                else:
                    dp[i][j] = (dp[i - 1][j] & (s1[i - 1] == s3[i + j - 1])) | \
                               (dp[i][j - 1] & (s2[j - 1] == s3[i + j - 1]))
        return dp[m][n]
print Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac")
print Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc")
print Solution().isInterleave("db", "b", "cbb")
