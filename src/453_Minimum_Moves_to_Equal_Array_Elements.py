class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        min_item = min(nums)
        res = 0
        for num in nums:
            res += num - min_item
        return res
