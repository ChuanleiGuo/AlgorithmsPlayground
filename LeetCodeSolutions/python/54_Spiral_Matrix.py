class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        res = []
        if not matrix:
            return []
        i, j, di, dj = 0, 0, 0, 1
        m, n = len(matrix), len(matrix[0])
        for v in xrange(m * n):
            res.append(matrix[i][j])
            matrix[i][j] = ''
            if matrix[(i + di) % m][(j + dj) % n] == '':
                di, dj = dj, -di
            i += di
            j += dj
        return res

m = [
 [1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]
]

print Solution().spiralOrder(m)
