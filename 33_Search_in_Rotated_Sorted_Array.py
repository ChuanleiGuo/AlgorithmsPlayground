class Solution(object):

    def __binary_search(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) / 2
            if nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                return mid
        return -1

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        pivot = 0
        result = -1
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                pivot = i
                break
        if target > nums[pivot:][-1]:
            result = self.__binary_search(nums[0: pivot], target)
        else:
            result = self.__binary_search(nums[pivot: len(nums)], target)
            result = -1 if result == -1 else result + pivot
        return result

arr = [4, 5, 6, 7, 0, 1, 2]
print Solution().search(arr, 2)
arr = [1, 3]
print Solution().search(arr, 2)
arr = [3, 1]
print Solution().search(arr, 2)
arr = [3, 1]
print Solution().search(arr, 0)
