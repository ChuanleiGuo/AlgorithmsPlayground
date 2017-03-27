class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        diff = 0
        for num in nums:
            diff ^= num

        diff &= -diff

        res = [0, 0]
        for num in nums:
            if diff & num == 0:
                res[0] ^= num
            else:
                res[1] ^= num

        return res
