# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
def guess(num):
    return 1


class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        start, end = 1, n
        while start <= end:
            mid = start + ((end - start) / 2)
            if guess(mid) == 0:
                return mid
            elif guess(mid) == 1:
                start = mid + 1
            elif guess(mid) == -1:
                end = mid - 1
        return start
