# straight solution
# class Solution:
#     def findLengthOfLCIS(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         res = cnt = 0
#         for i in range(len(nums)):
#             if i  == 0 or (nums[i - 1] < nums[i]):
#                 cnt += 1
#                 res = max(res, cnt)
#             else:
#                 cnt = 1
#         return res


# DP
class Solution:
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 0:
            return 0
        dp = [1] * len(nums)
        res = dp[0]

        for i in range(1, len(nums)):
            if nums[i - 1] < nums[i]:
                dp[i] = dp[i - 1] + 1
            else:
                dp[i] = 1

            res = max(res, dp[i])
        return res
