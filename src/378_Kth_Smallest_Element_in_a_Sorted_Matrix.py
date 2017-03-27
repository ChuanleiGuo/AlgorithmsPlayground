from heapq import heappush, heappop, heapify, heapreplace


class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        h = [(row[0], row, 1) for row in matrix]
        heapify(h)

        for _ in xrange(k - 1):
            val, row, index = h[0]
            if index < len(row):
                heapreplace(h, (row[index], row, index + 1))
            else:
                heappop(h)

        return h[0][0]
