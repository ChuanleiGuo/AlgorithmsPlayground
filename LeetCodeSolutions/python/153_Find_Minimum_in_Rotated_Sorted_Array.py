class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low, high = 0, len(nums) - 1
        while nums[low] > nums[high] and low < high:
            mid = low + ((high - low) >> 1)
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid

        return nums[low]
