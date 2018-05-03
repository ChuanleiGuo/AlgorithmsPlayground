from math import sqrt

class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 1: 
            return False
        res = 0
        for i in range(2, int(sqrt(num)) + 1):
            if num % i == 0:
                res += i + num / i
        res += 1
        return res == num
 