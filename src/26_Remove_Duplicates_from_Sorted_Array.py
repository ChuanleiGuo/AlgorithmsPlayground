class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return len(nums)
        low = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[low] = nums[i]
                low += 1
        return low

arr = [1, 1, 2]
print Solution().removeDuplicates(arr)