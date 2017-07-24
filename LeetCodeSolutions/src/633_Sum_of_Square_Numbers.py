from math import sqrt

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        low, high = 0, int(sqrt(c))
        while low <= high:
            cur = low ** 2 + high ** 2
            if cur < c:
                low += 1
            elif cur > c:
                high -= 1
            else:
                return True
        return False
