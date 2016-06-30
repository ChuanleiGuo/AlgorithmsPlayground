class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for i in range(0, 32):
            s = 0
            for num in nums:
                if ((num >> i) & 1) == 1:
                    s += 1
                    s %= 3

            if i == 31 and s:
                res -= 1 << 31
            else:
                res |= s << i

        return res
