class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        if dungeon is None or len(dungeon) == 0 or len(dungeon[0]) == 0:
            return 0

        m = len(dungeon)
        n = len(dungeon[0])

        health = [[0] * n for _ in range(m)]

        health[m - 1][n - 1] = max(1 - dungeon[m - 1][n - 1], 1)

        for i in range(m - 2, -1, -1):
            health[i][n - 1] = max(health[i + 1][n - 1] - dungeon[i][n - 1], 1)

        for j in range(n - 2, -1, -1):
            health[m - 1][j] = max(health[m - 1][j + 1] - dungeon[m - 1][j], 1)

        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                down = max(health[i + 1][j] - dungeon[i][j], 1)
                right = max(health[i][j + 1] - dungeon[i][j], 1)
                health[i][j] = min(down, right)

        return health[0][0]
