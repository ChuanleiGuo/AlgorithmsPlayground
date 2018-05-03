class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        temp_length = 0
        for num in nums:
            if num != 1:
                res = max(res, temp_length)
                temp_length = 0
                continue

            if num == 1:
                temp_length += 1
        return max(res, temp_length)
