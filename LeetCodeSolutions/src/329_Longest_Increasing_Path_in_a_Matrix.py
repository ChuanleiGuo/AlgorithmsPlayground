class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        INT_MIN = - (2 ** 31)
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        max_length = 0
        row, column = len(matrix), len(matrix[0])

        cache = [[0] * column for _ in range(row)]
        for i in range(row):
            for j in range(column):
                max_length = max(self.__dfs(matrix, INT_MIN, i, j, row, column, cache),\
                                 max_length)
        return max_length

    def __dfs(self, matrix, min_ele, i, j, row, column, cache):

        if i < 0 or j < 0 or i >= row or j >= column:
            return 0

        if matrix[i][j] <= min_ele:
            return 0

        if cache[i][j] != 0:
            return cache[i][j]

        min_ele = matrix[i][j]

        up = self.__dfs(matrix, min_ele, i - 1, j, row, column, cache) + 1
        down = self.__dfs(matrix, min_ele, i + 1, j, row, column, cache) + 1
        left = self.__dfs(matrix, min_ele, i, j - 1, row, column, cache) + 1
        right = self.__dfs(matrix, min_ele, i, j + 1, row, column, cache) + 1

        max_length = max(up, down, left, right)
        cache[i][j] = max_length

        return max_length
