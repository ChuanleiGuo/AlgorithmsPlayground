class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g = sorted(g)
        s = sorted(s)

        res = 0
        cur_iter = 0
        for i in range(len(g)):
            for j in range(cur_iter, len(s)):
                if s[j] >= g[i]:
                    res += 1
                    cur_iter = j + 1
                    break
        return res
