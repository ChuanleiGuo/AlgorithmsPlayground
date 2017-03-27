class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        cols = [[False] * 9 for _ in range(9)]
        rows = [[False] * 9 for _ in range(9)]
        blocks = [[False] * 9 for _ in range(9)]

        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] == '.':
                    continue

                val = int(board[i][j]) - 1
                k = (i / 3) * 3 + j / 3

                cols[j][val] = True
                rows[i][val] = True
                blocks[k][val] = True

        self.dfs(board, cols, rows, blocks)

    def dfs(self, board, cols, rows, blocks):
        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] == '.':
                    k = (i / 3) * 3 + j / 3
                    for num in range(0, 9):
                        if (not rows[i][num]) and (not cols[j][num]) and (not blocks[k][num]):
                            rows[i][num] = cols[j][num] = blocks[k][num] = True
                            board[i][j] = str(num + 1)
                            if self.dfs(board, cols, rows, blocks):
                                return True
                            rows[i][num] = cols[j][num] = blocks[k][num] = False
                            board[i][j] = '.'
                    return False
        return True
