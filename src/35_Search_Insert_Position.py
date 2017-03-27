class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) / 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        if low > len(nums) - 1:
            return len(nums)
        if nums[low] > target:
            return low
        else:
            return low + 1

nums = [1, 3, 5, 6]
print Solution().searchInsert(nums, 5)
print Solution().searchInsert(nums, 2)
print Solution().searchInsert(nums, 7)
print Solution().searchInsert(nums, 0)
nums = [1, 3]
print Solution().searchInsert(nums, 1)
nums = [1]
print Solution().searchInsert(nums, 1)
