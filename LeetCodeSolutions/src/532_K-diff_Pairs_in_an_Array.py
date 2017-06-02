from collections import Counter


class Solution(object):
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        res = 0
        counter = Counter(nums)
        for num in counter:
            if (k > 0 and num + k in counter) or (k == 0 and counter[num] > 1):
                res += 1
        return res
