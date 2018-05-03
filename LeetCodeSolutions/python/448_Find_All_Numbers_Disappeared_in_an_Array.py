class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for num in nums:
            idx = abs(num) - 1
            nums[idx] = -nums[idx] if nums[idx] > 0 else nums[idx]

        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)

        return res