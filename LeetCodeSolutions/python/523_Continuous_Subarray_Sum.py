class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        sum_dict = {0: -1}
        running_sum = 0
        for i in range(len(nums)):
            running_sum += nums[i]
            if k != 0:
                running_sum %= k
            if running_sum not in sum_dict:
                sum_dict[running_sum] = i
            else:
                if i - sum_dict[running_sum] > 1:
                    return True
        return False
