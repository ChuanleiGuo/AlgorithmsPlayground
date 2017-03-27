class Solution(object):

    def __insert_position(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) / 2
            if nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
        return low

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        l = self.__insert_position(nums, target - 0.5)
        r = self.__insert_position(nums, target + 0.5)
        if l >= len(nums):
            return [-1, -1]
        if target != nums[l]:
            return [-1, -1]
        else:
            return [l, r - 1]

arr = [5, 7, 7, 8, 8, 10]
print Solution().searchRange(arr, 8)
arr = [1]
print Solution().searchRange(arr, 1)
arr = [3, 3]
print Solution().searchRange(arr, 2)
arr = [2, 2]
print Solution().searchRange(arr, 3)
