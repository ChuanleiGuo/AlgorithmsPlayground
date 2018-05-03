class Solution(object):

    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        res = []
        if not matrix or len(matrix) == 0:
            return []
        n, m = len(matrix), len(matrix[0])

        pacific = [[False] * m for _ in range(n)]
        atlantic = [[False] * m for _ in range(n)]
        pqueue = []
        aqueue = []
        for i in range(n):
            pqueue.append((i, 0))
            aqueue.append((i, m - 1))
            pacific[i][0] = True
            atlantic[i][m - 1] = True
        for i in range(m):
            pqueue.append((0, i))
            aqueue.append((n - 1, i))
            pacific[0][i] = True
            atlantic[n - 1][i] = True

        self.bfs(matrix, pqueue, pacific)
        self.bfs(matrix, aqueue, atlantic)

        for i in range(n):
            for j in range(m):
                if pacific[i][j] and atlantic[i][j]:
                    res.append([i, j])
        return res

    def bfs(self, matrix, queue, visit):
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        n, m = len(matrix), len(matrix[0])
        while len(queue):
            cur = queue.pop(0)
            for d in directions:
                x = cur[0] + d[0]
                y = cur[1] + d[1]
                if x < 0 or x >= n or y < 0 or y >= m or visit[x][y] or \
                        matrix[x][y] < matrix[cur[0]][cur[1]]:
                    continue
                visit[x][y] = True
                queue.append((x, y))
