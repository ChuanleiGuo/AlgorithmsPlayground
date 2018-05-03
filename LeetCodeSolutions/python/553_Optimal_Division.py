class Solution(object):
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        ans = ""
        if len(nums) == 0:
            return ans
        ans = str(nums[0])
        if len(nums) == 1:
            return ans
        if len(nums) == 2:
            return ans + "/" + str(nums[1])
        ans += "/(" + str(nums[1])
        for i in range(2, len(nums)):
            ans += "/" + str(nums[i])
        ans += ")"
        return ans
