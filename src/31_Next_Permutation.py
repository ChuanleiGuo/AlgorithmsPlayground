class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums))[::-1]:
            for j in range(len(nums) - 1, i, -1):
                if nums[i] < nums[j]:
                    nums[i], nums[j] = nums[j], nums[i]
                    nums[i + 1: len(nums)] = nums[i + 1: len(nums)][::-1]
                    print arr
                    return
        nums.sort()

arr = [1, 3, 2]
Solution().nextPermutation(arr)
arr = [3, 2, 1]
Solution().nextPermutation(arr)
arr = [1, 1, 5]
Solution().nextPermutation(arr)