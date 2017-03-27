class Solution(object):
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        n, m = len(board), len(board[0])
        res = 0
        for i in range(n):
            for j in range(m):
                if board[i][j] == 'X' and (i == 0 or board[i - 1][j] != 'X') and \
                        (j == 0 or board[i][j - 1] != 'X'):
                    res += 1
        return res
