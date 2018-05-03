class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        next = [-1] * n
        stack = []

        for i in range(2 * n):
            num = nums[i % n]
            while len(stack) != 0 and nums[stack[-1]] < num:
                next[stack.pop()] = num
            if i < n:
                stack.append(i)
        return next
