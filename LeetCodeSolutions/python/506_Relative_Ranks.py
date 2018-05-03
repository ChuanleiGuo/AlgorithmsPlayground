class Solution(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        sorted_nums = sorted(nums)[::-1]
        rank = ["Gold Medal", "Silver Medal", "Bronze Medal"] \
            + map(str, range(4, len(nums) + 1))
        return map(dict(zip(sorted_nums, rank)).get, nums)
