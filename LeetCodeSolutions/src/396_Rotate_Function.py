class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        s = sum(A)
        candidate = 0

        for i in range(len(A)):
            candidate += i * A[i]

        best = candidate
        for i in range(1, len(A)):
            candidate = candidate - s + (len(A) * A[i - 1])
            best = max(best, candidate)

        return best
