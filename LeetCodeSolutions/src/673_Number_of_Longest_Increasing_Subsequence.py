class Solution:
    def findNumberOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        res = max_len = 0
        lens = [0] * length
        cnts = [0] * length

        for i in range(length):
            lens[i] = cnts[i] = 1
            for j in range(i):
                if nums[i] > nums[j]:
                    if lens[i] == lens[j] + 1:
                        cnts[i] += cnts[j]
                    if lens[i] < lens[j] + 1:
                        lens[i] = lens[j] + 1
                        cnts[i] = cnt[j]

            if max_len == lens[i]:
                res += cnts[i]
            if max_len < lens[i]:
                max_len = lens[i]
                res = cnts[i]

        return res
