class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        INT_MAX = 2 ** 31 - 1
        INT_MIN = - (2 ** 31)
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX
        signal = 1
        if dividend < 0:
            signal = - signal
        if divisor < 0:
            signal = - signal
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        while dividend >= divisor:
            d, times = divisor, 1
            while d <= dividend:
                d <<= 1
                times <<= 1
            d >>= 1
            times >>= 1
            res += times
            dividend -= d
        if signal == 1:
            return res
        else:
            return 0 - res