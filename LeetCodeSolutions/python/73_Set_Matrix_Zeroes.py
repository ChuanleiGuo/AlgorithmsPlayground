class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        col_has_zero, row_has_zero = False, False

        if len(matrix) == 0 or len(matrix[0]) == 0:
            return

        for col in range(len(matrix[0])):
            if matrix[0][col] == 0:
                row_has_zero = True

        for row in range(len(matrix)):
            if matrix[row][0] == 0:
                col_has_zero = True

        for row in range(1, len(matrix)):
            for col in range(1, len(matrix[0])):
                if matrix[row][col] == 0:
                    matrix[row][0] = 0
                    matrix[0][col] = 0

        for row in range(1, len(matrix)):
            for col in range(1, len(matrix[0])):
                if matrix[row][0] == 0 or matrix[0][col] == 0:
                    matrix[row][col] = 0

        if col_has_zero:
            for row in range(len(matrix)):
                matrix[row][0] = 0

        if row_has_zero:
            for col in range(len(matrix[0])):
                matrix[0][col] = 0
