class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        medium = self.__find_medium(nums, 0, len(nums) - 1, (len(nums) + 1) >> 1)
        start, end, mid = 0, len(nums) - 1, (len(nums) + 1) >> 1
        temp = [0] * len(nums)

        for num in nums:
            if num < medium:
                temp[start] = num
                start += 1
            elif num > medium:
                temp[end] = num
                end -= 1

        while start < mid:
            temp[start] = medium
            start += 1

        while end >= mid:
            temp[end] = medium
            end -= 1

        start, end = mid - 1, len(nums) - 1
        for i in range(len(nums)):
            if i & 1 == 0:
                nums[i] = temp[start]
                start -= 1
            else:
                nums[i] = temp[end]
                end -= 1

    def __find_medium(self, nums, start, end, k):
        if start >= end:
            return nums[end]
        i = self.__partition(nums, start, end)
        cnt = i - start + 1
        if cnt == k:
            return nums[i]
        return self.__find_medium(nums, start, i - 1, k) if cnt > k \
            else self.__find_medium(nums, i + 1, end, k - cnt)

    def __partition(self, nums, start, end):
        val = nums[start]
        i, j = start + 1, end
        while True:
            while i < end and nums[i] <= val:
                i += 1
            while j > start and nums[j] >= val:
                j -= 1
            if i >= j:
                break
            nums[i], nums[j] = nums[j], nums[i]

        nums[start], nums[j] = nums[j], nums[start]
        return j
