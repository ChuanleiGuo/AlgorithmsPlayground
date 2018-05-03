from random import randint


class Solution(object):
    def __init__(self, nums):
        """

        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        r = self.nums.index(target)
        steps = [r]

        i = r + 1
        while i < len(self.nums):
            if self.nums[i] == target:
                steps.append(i)
                if steps[randint(0, len(steps) - 1)] == i:
                    r = i
            i += 1
        return r
