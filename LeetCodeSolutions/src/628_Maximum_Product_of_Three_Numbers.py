class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        left = nums[0] * nums[1] * nums[2]
        right = nums[-1] * nums[-2] * nums[-3]
        return max(left, right)
    