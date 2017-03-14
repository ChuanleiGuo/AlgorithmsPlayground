class Solution(object):
    def findSubsequences(self, nums):
        def helper(arr, i):
            if len(arr) > 1:
                res.append(list(arr))
            unique = []
            for k in range(i, len(nums)):
                if i > 0 and nums[k] < nums[i - 1]:
                    continue
                if nums[k] in unique:
                    continue
                arr.append(nums[k])
                unique.append(nums[k])
                helper(arr, k + 1)
                arr.pop()

        res = []
        helper([], 0)
        return res
