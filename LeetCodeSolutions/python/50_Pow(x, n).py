class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        flag = True
        if n < 0:
            flag = False
            n = abs(n)
        res = 1
        while n > 0:
            if n & 1:
                res *= x
            x *= x
            n >>= 1
        if not flag:
            return 1 / res
        return res

print Solution().myPow(2, 3)
print Solution().myPow(34.00515, -3)
