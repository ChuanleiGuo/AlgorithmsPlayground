class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        k = 2
        if len(nums) == 0:
            return 0

        m = 1
        count = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                if count < k:
                    nums[m] = nums[i]
                    m += 1
                count += 1
            else:
                count = 1
                nums[m] = nums[i]
                m += 1
        return m
