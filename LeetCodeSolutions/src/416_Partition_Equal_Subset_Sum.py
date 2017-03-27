class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums or len(nums) == 0:
            return True

        volume = sum(nums)
        if volume % 2 != 0:
            return False

        volume /= 2
        dp = [False] * (volume + 1)
        dp[0] = True

        for i in range(1, len(nums) + 1):
            for j in range(volume, nums[i - 1] - 1, -1):
                dp[j] = dp[j] or dp[j - nums[i - 1]]

        return dp[volume]
