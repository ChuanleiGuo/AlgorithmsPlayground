class Solution(object):
    def __init__(self):
        self.sum_to_nums = {}

    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0 or target < 0 or not nums:
            return 0
        if target == 0:
            return 1
        count = 0
        if target in self.sum_to_nums:
            return self.sum_to_nums[target]
        for num in nums:
            count += self.combinationSum4(nums, target - num)
            self.sum_to_nums[target] = count
        return count
