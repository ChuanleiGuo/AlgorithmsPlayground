class Solution(object):
    dx = [-1, 0, 0, 1]
    dy = [0, 1, -1, 0]

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        island = 0

        if grid is None or len(grid) == 0:
            return 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.__explore(grid, i, j)
                    island += 1
        return island

    def __explore(self, grid, i, j):
        grid[i][j] = '0'
        for d in range(len(self.dx)):
            if 0 <= i + self.dy[d] < len(grid) and\
                                    0 <= j + self.dx[d] < len(grid[0]) and \
                                    grid[i + self.dy[d]][j + self.dx[d]] == '1':
                self.__explore(grid, i + self.dy[d], j + self.dx[d])
