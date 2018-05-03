class Solution(object):
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        mem = {}

        def helper(i, j):
            if (i, j) not in mem:
                mem[(i, j)] = nums[i] if i == j else \
                    max(nums[i] - helper(i + 1, j), nums[j] - helper(i, j - 1))
            return mem[(i, j)]
        return helper(0, len(nums) - 1) >= 0
