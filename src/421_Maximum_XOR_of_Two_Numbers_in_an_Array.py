class Solution(object):
    def findMaximumXOR(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, mask = 0, 0
        for i in range(31, -1, -1) :
            mask |= (1 << i)
            s = set()
            for num in nums:
                s.add(num & mask)
            tmp = res | (1 << i)
            for prefix in s:
                if (tmp ^ prefix) in s:
                    res = tmp
                    break
        return res
