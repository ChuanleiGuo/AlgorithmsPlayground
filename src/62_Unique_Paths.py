class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # Space: O(m * n)
        # if m == 0 or n == 0:
        #     return 0
        # paths = [[0] * n for _ in range(m)]
        # for i in range(m):
        #     for j in range(n):
        #         if i == 0 and j == 0:
        #             paths[i][j] = 1
        #         else:
        #             paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
        # return paths[m - 1][n - 1]

        paths = [0] * m
        paths[0] = 1
        for i in range(n):
            for j in range(1, m):
                paths[j] += paths[j - 1]
        return paths[m - 1]
