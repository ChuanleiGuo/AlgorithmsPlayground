class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        self.row = len(matrix)
        self.col = len(matrix[0]) if self.row else 0
        self.grids = [[0] * (self.col + 1) for _ in range(self.row + 1)]
        for i in range(1, self.row + 1):
            for j in range(1, self.col + 1):
                self.grids[i][j] = matrix[i - 1][j - 1] + self.grids[i - 1][j] + \
                    self.grids[i][j - 1] - self.grids[i - 1][j - 1]

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.grids[row2 + 1][col2 + 1] - self.grids[row2 + 1][col1] - \
            self.grids[row1][col2 + 1] + self.grids[row1][col1]
