class Solution(object):
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        length = 1
        count = 9
        start = 1

        num = n
        while num > count * length:
            num -= count * length
            count *= 10
            length += 1
            start *= 10

        start += (num - 1) / length
        s = str(start)
        return int(s[(num - 1) % length])
