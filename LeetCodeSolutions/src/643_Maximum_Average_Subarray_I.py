class Solution:
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        max_res = sum(nums[0: k])
        res = max_res
        for i in range(1, len(nums) - k + 1):
            res = res - nums[i - 1] + nums[i + k - 1]
            max_res = max(max_res, res)
        return max_res / k
