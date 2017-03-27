class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0

        max_temp = nums[0]
        min_temp = nums[0]
        result = nums[0]

        for i in range(1, len(nums)):
            a = max_temp * nums[i]
            b = min_temp * nums[i]
            max_temp = max(a, b, nums[i])
            min_temp = min(a, b, nums[i])
            result = max(min_temp, max_temp, result)
        return result
