class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        max_reach, end = 0, len(nums) - 1
        for idx, num in enumerate(nums):
            if max_reach < idx:
                return False
            if max_reach >= end:
                return True
            max_reach = max(max_reach, nums[idx] + idx)
