class Solution(object):

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        res = sum(nums[:3])
        for i in range(len(nums)):
            low, high = i + 1, len(nums) - 1
            while low < high:
                s = sum([nums[i], nums[low], nums[high]])
                if abs(s - target) < abs(res - target):
                    res = s
                if s < target:
                    low += 1
                elif s > target:
                    high -= 1
                else:
                    return res
        return res