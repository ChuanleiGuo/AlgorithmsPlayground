class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        start, end = 0, num
        while start <= end:
            mid = start + ((end - start) >> 1)
            if mid ** 2 == num:
                return True
            if mid ** 2 < num:
                start = mid + 1
            else:
                end = mid - 1
        return False
