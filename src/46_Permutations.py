class Solution(object):
    def permute(self, nums):
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
        if start == end:
            sub_list = []
            for num in nums:
                sub_list.append(num)
            result.append(sub_list)
        else:
            for i in range(start, end + 1):
                nums[i], nums[start] = nums[start], nums[i]
                self.dfs(nums, start + 1, end, result)
                nums[i], nums[start] = nums[start], nums[i]

nums = [1, 2, 3]
print Solution().permute(nums)
