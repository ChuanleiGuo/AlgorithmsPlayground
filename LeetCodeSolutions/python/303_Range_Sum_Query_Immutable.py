class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.left = [0] * (len(nums) + 1)
        count = 0
        for num in nums:
            self.left[count + 1] = self.left[count] + num
            count += 1

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.left[j + 1] - self.left[i]
