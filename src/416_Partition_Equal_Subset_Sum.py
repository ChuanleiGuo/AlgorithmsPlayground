class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums or len(nums) == 0:
            return True

        volumn = sum(nums)
        if volumn % 2 != 0:
            return False

        volumn /= 2
        dp = [False] * (volumn + 1)
        dp[0] = True

        for i in range(1, len(nums) + 1):
            for j in range(volumn, nums[i - 1] - 1, -1):
                dp[j] = dp[j] or dp[j - nums[i - 1]]

        return dp[volumn]
