class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 0:
            return None
        result = []
        self.dfs(nums, 0, len(nums) - 1, result)
        return result

    def dfs(self, nums, start, end, result):
        def no_swap(nums, start ,i):
            for j in range(start, i):
                if nums[i] == nums[j]:
                    return True
            return False

        if start == end:
            sub_list = []
            for num in nums:
                sub_list.append(num)
            result.append(sub_list)
        else:
            for i in range(start, end + 1):
                if no_swap(nums, start, i):
                    continue
                nums[i], nums[start] = nums[start], nums[i]
                self.dfs(nums, start + 1, end, result)
                nums[i], nums[start] = nums[start], nums[i]

nums = [1, 1, 2]
print Solution().permuteUnique(nums)
