class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        n, m = len(nums1), len(nums2)
        res = [0] * k
        i = max(0, k - m)
        while i <= k and i <= n:
            candidate = self.__merage(self.__max_array(nums1, i), self.__max_array(nums2, k - i), k)
            if self.__greater(candidate, 0, res, 0):
                res = candidate
            i += 1
        return res

    def __merage(self, nums1, nums2, k):
        ans = [0] * k
        i = j = r = 0
        while r < k:
            if self.__greater(nums1, i, nums2, j):
                ans[r] = nums1[i]
                i += 1
            else:
                ans[r] = nums2[j]
                j += 1
            r += 1
        return ans

    def __greater(self, nums1, i, nums2, j):
        while i < len(nums1) and j < len(nums2) and nums1[i] == nums2[j]:
            i += 1
            j += 1
        return j == len(nums2) or (i < len(nums1) and nums1[i] > nums2[j])

    def __max_array(self, nums, k):
        ans = [0] * k
        i = j = 0
        n = len(nums)

        while i < n:
            while n - i + j > k and j > 0 and ans[j - 1] < nums[i]:
                j -= 1
            if j < k:
                ans[j] = nums[i]
                j += 1
            i += 1
        return ans
