class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        def dfs(row, col, board):
            if row < 0 or row >= len(board) or col < 0 or col >= len((board[0])):
                return
            if board[row][col] == '*' or board[row][col] == 'X':
                return
            row_nums, col_nums = len(board), len(board[0])
            board[row][col] = '*'
            if row + 1 < row_nums:
                dfs(row + 1, col, board)

            if row - 1 > 0:
                dfs(row - 1, col, board)

            if col + 1 < col_nums:
                dfs(row, col + 1, board)

            if col - 1 > 0:
                dfs(row, col - 1, board)

        if board is None or len(board) == 0 or len(board[0]) == 0:
            return

        row_nums, col_nums = len(board), len(board[0])
        for i in range(row_nums):
            for j in range(col_nums):
                if i == 0 or i == row_nums - 1 or j == 0 or j == col_nums - 1:
                    if board[i][j] == 'O':
                        dfs(i, j, board)

        for i in range(row_nums):
            for j in range(col_nums):
                if board[i][j] == '*':
                    board[i][j] = 'O'
                else:
                    board[i][j] = 'X'
