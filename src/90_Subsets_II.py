class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = [[]]
        begin = 0
        for idx, num in enumerate(nums):
            if idx == 0 or nums[idx] != nums[idx - 1]:
                begin = 0
            size = len(res)
            for j in range(begin, size):
                l = list(res[j])
                l.append(num)
                res.append(l)
            begin = size
        return res
