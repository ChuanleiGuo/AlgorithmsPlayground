class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        matrix = [[0] * n for _ in range(n)]
        n_start, n_end = 0, n
        count = 1
        while n_start < n_end:
            for i in range(n_start, n_end):
                matrix[n_start][i] = count
                count += 1
            for i in range(n_start + 1, n_end):
                matrix[i][n_end - 1] = count
                count += 1
            for i in range(n_end - 2, n_start - 1, -1):
                matrix[n_end - 1][i] = count
                count += 1
            for i in range(n_end - 2, n_start, -1):
                matrix[i][n_start] = count
                count += 1
            n_end -= 1
            n_start += 1
        return matrix
