class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        MAX_INT = 2 ** 31 - 1

        if not nums or len(nums) == 0:
            return 0

        i = j = n_sum = 0
        min_len = MAX_INT
        while j < len(nums):
            n_sum += nums[j]
            j += 1
            while n_sum >= s:
                min_len = min(min_len, j - i)
                n_sum -= nums[i]
                i += 1

        return min_len if min_len != MAX_INT else 0
