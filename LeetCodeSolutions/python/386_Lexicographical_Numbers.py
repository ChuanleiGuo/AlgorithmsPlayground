class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = []
        cur = 1
        for i in xrange(1, n + 1):
            res.append(cur)
            if cur * 10 <= n:
                cur *= 10
            elif cur % 10 != 9 and cur + 1 <= n:
                cur += 1
            else:
                while ((cur / 10) % 10) == 9:
                    cur /= 10
                cur = cur / 10 + 1
        return res
