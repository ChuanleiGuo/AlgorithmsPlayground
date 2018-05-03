from heapq import heappush, heappop


class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        pq = []
        res = []
        m, n = len(nums1), len(nums2)
        if len(nums1) == 0 or len(nums2) == 0:
            return []
        for j in xrange(0, n):
            heappush(pq, (nums1[0] + nums2[j], 0, j))
        for i in xrange(0, min(k, m * n)):
            t = heappop(pq)
            res.append([nums1[t[1]], nums2[t[2]]])
            if t[1] == m - 1:
                continue
            heappush(pq, (nums1[t[1] + 1] + nums2[t[2]], t[1] + 1, t[2]))
        return res
