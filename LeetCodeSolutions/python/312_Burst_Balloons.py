class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [1] + nums + [1]
        l = len(nums)
        dp = [[0] * l for _ in range(l)]
        for k in range(2, l):
            for left in range(0, l - k):
                right = left + k
                for i in range(left + 1, right):
                    dp[left][right] = max(dp[left][right],
                                          nums[left] * nums[i] * nums[right]
                                          + dp[left][i] + dp[i][right])
        return dp[0][l - 1]
