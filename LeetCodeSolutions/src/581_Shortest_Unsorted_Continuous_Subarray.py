class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        beg, end = -1, -2
        min_num, max_num = nums[n - 1], nums[0]

        for i in range(1, n):
            max_num = max(max_num, nums[i])
            min_num = min(min_num, nums[n - 1 - i])
            if nums[i] < max_num:
                end = i
            if nums[n - i - 1] > min_num:
                beg = n - i - 1
        return end - beg + 1
