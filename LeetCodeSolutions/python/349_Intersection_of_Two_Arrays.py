class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        s = set(nums1)
        s2 = set(nums2)
        return list(s.intersection(s2))
