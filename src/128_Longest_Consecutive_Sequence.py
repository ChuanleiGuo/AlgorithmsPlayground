class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        union = set(nums)
        m = 0
        count = 0
        for num in nums:
            if not num - 1 in union:
                count = 0
                while num in union:
                    num += 1
                    count += 1
                m = max(m, count)
        return m
