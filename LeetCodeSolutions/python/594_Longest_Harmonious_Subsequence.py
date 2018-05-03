from collections import Counter


class Solution:
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        num_counter = Counter(nums)
        max_len = 0
        for num in num_counter.keys():
            if num + 1 in num_counter:
                max_len = max(max_len, num_counter[num] + num_counter[num + 1])
        return max_len
