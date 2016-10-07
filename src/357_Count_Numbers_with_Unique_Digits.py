class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 1

        res = 10
        unique_digits = 9
        available_number = 9
        while n > 1 and available_number > 0:
            unique_digits *= available_number
            res += unique_digits
            available_number -= 1
            n -= 1
        return res
