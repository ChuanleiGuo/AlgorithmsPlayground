class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board or len(board) == 0 or not board[0] or len(board[0]) == 0:
            return

        m, n = len(board), len(board[0])
        dx = [-1, -1, -1, 0, 1, 1, 1, 0]
        dy = [-1, 0, 1, 1, 1, 0, -1, -1]

        for i in range(0, m):
            for j in range(0, n):
                cnt = 0

                for k in range(0, 8):
                    x = i + dx[k]
                    y = j + dy[k]

                    if 0 <= x < m and 0 <= y < n and \
                            (board[x][y] == 1 or board[x][y] == 2):
                        cnt += 1

                if board[i][j] and (cnt < 2 or cnt > 3):
                    board[i][j] = 2
                elif not board[i][j] and cnt == 3:
                    board[i][j] = 3

        for i in range(0, m):
            for j in range(0, n):
                board[i][j] %= 2
