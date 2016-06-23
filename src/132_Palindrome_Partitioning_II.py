class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        is_palin = [[False] * n for _ in range(n)]
        cut = [0] * n
        for i in range(n):
            m = i
            for j in range(i + 1):
                if s[i] == s[j] and (j + 1 > i - 1 or is_palin[j + 1][i - 1]):
                    is_palin[j][i] = True
                    m = 0 if j == 0 else min(m, cut[j - 1] + 1)
            cut[i] = m
        return cut[n - 1]
