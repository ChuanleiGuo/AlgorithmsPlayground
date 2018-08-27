class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (board[i][j] == 'O') {
                        helper(board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col > board[0].length) {
            return;
        }
        if (board[row][col] == '*' || board[row][col] == 'X') {
            return;
        }
        int rowNum = board.length;
        int colNum = board[0].length;
        board[row][col] = '*';
        if (row + 1 < rowNum) {
            helper(board, row + 1, col);
        }
        if (row - 1 > 0) {
            helper(board, row - 1, col);
        }
        if (col + 1 < colNum) {
            helper(board, row, col + 1);
        }
        if (col - 1 > 0) {
            helper(board, row, col - 1);
        }
    }
}
