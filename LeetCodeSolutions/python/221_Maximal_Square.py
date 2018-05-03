class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or len(matrix) == 0:
            return 0
        row, col = len(matrix), len(matrix[0])
        max_size = 0
        dp = [[0] * col for _ in xrange(row)]

        for j in range(0, col):
            dp[0][j] = int(matrix[0][j])
            max_size = max(max_size, dp[0][j])

        for i in range(0, row):
            dp[i][0] = int(matrix[i][0])
            max_size = max(max_size, dp[i][0])

        for i in range(1, row):
            for j in range(1, col):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                    max_size = max(max_size, dp[i][j])

        return max_size ** 2

m = [
    ['1', '0', '1', '0', '0'],
    ['1', '0', '1', '1', '1'],
    ['1', '1', '1', '1', '1'],
    ['1', '0', '0', '1', '0']
]

print Solution().maximalSquare(m)
