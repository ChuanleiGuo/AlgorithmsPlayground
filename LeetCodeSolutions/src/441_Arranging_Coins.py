class Solution(object):

    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """

        def rshift(val, n):
            return val >> n if val >= 0 else (val + 0x100000000) >> n

        start, end = 0, n
        while start <= end:
            mid = start + rshift(end - start, 1)
            if (0.5 * mid * mid + 0.5 * mid) <= n:
                start = mid + 1
            else:
                end = mid - 1
        return start - 1
