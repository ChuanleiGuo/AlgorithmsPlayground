class Solution(object):
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        table = [[0] * len(s) for _ in range(len(s))]

        for i in range(len(s) - 1, -1, -1):
            table[i][i] = 1
            for j in range(i + 1, len(s)):
                if s[i] == s[j]:
                    table[i][j] = table[i + 1][j - 1] + 2
                else:
                    table[i][j] = max(table[i + 1][j], table[i][j - 1])
        return table[0][len(s) - 1]
