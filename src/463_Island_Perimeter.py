class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        island_num = neighbor_num = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    island_num += 1
                    if i < len(grid) - 1 and grid[i + 1][j] == 1:
                        neighbor_num += 1
                    if j < len(grid[i]) - 1 and grid[i][j + 1] == 1:
                        neighbor_num += 1
        return island_num * 4 - neighbor_num * 2
