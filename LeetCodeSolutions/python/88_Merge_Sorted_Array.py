class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        end = n + m - 1
        p1, p2 = m - 1, n - 1
        while end >= 0:
            if p1 < 0:
                nums1[end] = nums2[p2]
                end -= 1
                p2 -= 1
            elif p2 < 0:
                nums1[end] = nums1[p1]
                end -= 1
                p1 -= 1
            else:
                if nums1[p1] > nums2[p2]:
                    nums1[end] = nums1[p1]
                    end -= 1
                    p1 -= 1
                else:
                    nums1[end] = nums2[p2]
                    end -= 1
                    p2 -= 1
