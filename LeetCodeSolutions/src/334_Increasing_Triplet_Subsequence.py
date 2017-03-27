class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        INT_MAX = 2 ** 31 - 1
        small = big = INT_MAX

        for num in nums:
            if num <= small:
                small = num
            elif num <= big:
                big = num
            else:
                return True
        return False
