class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        presum = {0: 1}
        s = res = 0
        for num in nums:
            s += num
            res += presum.get(s - k, 0)
            presum[s] = presum.get(s, 0) + 1
        return res
 