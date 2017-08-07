class Solution:
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        record = [0] * (len(nums) + 1)
        for num in nums:
            record[num] += 1
        
        dup, miss = 0, 0
        for idx, val in enumerate(record):
            if val == 2:
                dup = idx
            if val == 0:
                miss = idx
        return [dup, miss]
