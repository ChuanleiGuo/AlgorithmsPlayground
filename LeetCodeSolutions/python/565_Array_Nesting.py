class Solution(object):
    def arrayNesting(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_size = 0
        for i in range(len(nums)):
            size = 0
            k = i
            while nums[k] >= 0:
                ak = nums[k]
                nums[k] = -1
                k = ak
                size += 1
            max_size = max(max_size, size)
        return max_size
