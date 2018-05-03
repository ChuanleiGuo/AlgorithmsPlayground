class Solution(object):

    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        temp_sum, max_sum = 0, nums[0]
        for num in nums:
            temp_sum += num
            if temp_sum > max_sum:
                max_sum = temp_sum
            if temp_sum < 0:
                temp_sum = 0

        return max_sum

arr = [-3, -2, 0, -1]
print Solution().maxSubArray(arr)
