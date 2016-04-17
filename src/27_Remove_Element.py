class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        low = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[low] = nums[i]
                low += 1
        return low