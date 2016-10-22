class Solution(object):
    def getMoneyAmount(self, n):
        """
        :type n: int
        :rtype: int
        """
        def dp(table, start, end):
            if start >= end:
                return 0
            if table[start][end] != 0:
                return table[start][end]
            res = 2 ** 31 - 1
            for mid in xrange(start, end + 1):
                tmp = mid + max(dp(table, start, mid - 1), dp(table, mid + 1, end))
                res = min(res, tmp)
            table[start][end] = res
            return res

        table = [[0] * (n + 1) for _ in xrange(n + 1)]
        return dp(table, 1, n)
