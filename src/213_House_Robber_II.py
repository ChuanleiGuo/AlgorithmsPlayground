class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return nums[0] if nums else 0
        return max(self.__robber(nums[0: -1]), self.__robber(nums[1:]))

    def __robber(self, nums):
        pre = cur = 0
        for num in nums:
            temp = max(pre + num, cur)
            pre, cur = cur, temp
        return cur
