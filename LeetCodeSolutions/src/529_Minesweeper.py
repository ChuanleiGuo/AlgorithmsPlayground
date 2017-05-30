class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        m, n = len(board), len(board[0])
        row, col = click[0], click[1]

        if board[row][col] == 'M':
            board[row][col] = 'X'
        else:
            count = 0
            for i in range(-1, 2):
                for j in range(-1, 2):
                    if i == 0 and j == 0:
                        continue
                    r, c = row + i, col + j
                    if r < 0 or r >= m or c < 0 or c >= n:
                        continue
                    if board[r][c] == 'M' or board[r][c] == 'X':
                        count += 1
            
            if count > 0:
                board[row][col] = str(count)
            else:
                board[row][col] = 'B'
                for i in range(-1, 2):
                    for j in range(-1, 2):
                        if i == 0 and j == 0:
                            continue
                        r, c = row + i, col + j
                        if r < 0 or r >= m or c < 0 or c >= n:
                            continue
                        if board[r][c] == 'E':
                            self.updateBoard(board, [r, c])
        return board
