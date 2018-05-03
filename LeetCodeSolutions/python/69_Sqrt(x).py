class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        v = x
        while v * v > x:
            v = (v + (x / v)) >> 1

        return v
