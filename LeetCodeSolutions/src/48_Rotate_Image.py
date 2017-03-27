class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(0, n):
            for j in range(0, n - i):
                matrix[i][j], matrix[n - 1 - j][n - 1 - i] = \
                    matrix[n - 1 - j][n - 1 - i], matrix[i][j]

        for i in range(0, n / 2):
            for j in range(0, n):
                matrix[i][j], matrix[n - 1 - i][j] = \
                    matrix[n - 1 - i][j], matrix[i][j]
