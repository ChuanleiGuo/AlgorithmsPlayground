class UF:
    def __init__(self, n):
        self.__list = [0] * n
        for i in range(n):
            self.__list[i] = i

    def __root(self, i):
        while i != self.__list[i]:
            self.__list[i] = self.__list[self.__list[i]]
            i = self.__list[i]
        return i

    def connected(self, i, j):
        return self.__root(i) == self.__root(j)

    def union(self, i, j):
        ri = self.__root(i)
        rj = self.__root(j)
        self.__list[rj] = ri

    def max_union(self, grid):
        s = set()
        for i in range(len(self.__list)):
            x = i / len(grid[0])
            y = i % len(grid[0])
            if grid[x][y] == '1':
                s.add(self.__root(i))
        return len(s)


class Solution(object):

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if grid is None or len(grid) == 0:
            return 0
        height = len(grid)
        width = len(grid[0])
        total_size = height * width
        uf = UF(total_size)
        for i in range(total_size):
            x = i / width
            y = i % width
            up = x - 1
            right = y + 1
            if up >= 0 and grid[x][y] == '1' and grid[x][y] == grid[up][y]:
                uf.union(i, i - width)
            if right < width and grid[x][y] == '1' and grid[x][y] == grid[x][right]:
                uf.union(i, i + 1)
        return uf.max_union(grid)

print Solution().numIslands([
    '11110',
    '11010',
    '11000',
    '00000'])