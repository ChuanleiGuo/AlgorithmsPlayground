class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        total = len(nums1) + len(nums2)
        if total % 2 == 1:
            return self.__findKth(nums1, nums2, total / 2 + 1)
        else:
            return (self.__findKth(nums1, nums2, total / 2) +
                    self.__findKth(nums1, nums2, total / 2 + 1)) / 2.0

    def __findKth(self, nums1, nums2, k):
        m, n = len(nums1), len(nums2)
        if m > n:
            return self.__findKth(nums2, nums1, k)
        if m == 0:
            return nums2[k - 1]
        if k == 1:
            return min(nums1[0], nums2[0])
        pa = min(k / 2, m)
        pb = k - pa
        print pa, pb
        if nums1[pa - 1] < nums2[pb - 1]:
            return self.__findKth(nums1[pa:], nums2, k - pa)
        elif nums1[pa - 1] > nums2[pb - 1]:
            return self.__findKth(nums1, nums2[pb:], k - pb)
        else:
            return nums1[pa - 1]

nums1 = [1]
nums2 = [1]

print Solution().findMedianSortedArrays(nums1, nums2)