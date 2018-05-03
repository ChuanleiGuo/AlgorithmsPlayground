class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # hash map

        # if len(nums) == 0:
        #     return 0
        # d = {}
        # for num in nums:
        #     t = d.get(num, 0)
        #     if t == 1:
        #         del d[num]
        #     else:
        #         d[num] = t + 1
        # return d.keys()[0]

        # bit manipulation

        res = 0
        for num in nums:
            res = res ^ num
        return res
