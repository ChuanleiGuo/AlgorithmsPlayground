class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        res = 0
        while start < len(nums) - 1:
            res += 1
            index, max_len = 0, 0
            if start + nums[start] >= len(nums) - 1:
                return res
            for i in range(1, nums[start] + 1):
                if nums[start + i] + i > max_len:
                    index = start + i
                    max_len = nums[start + i] + i
            start = index
        return res

arr = [2, 3, 1, 1, 4]
print Solution().jump(arr)
