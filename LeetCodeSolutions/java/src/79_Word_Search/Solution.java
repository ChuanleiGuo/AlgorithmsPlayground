class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (searchWord(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 0; i < 4; i++) {
                int newx = x + dirs[i][0];
                int newy = y + dirs[i][1];
                if (inArea(board, newx, newy) && !visited[newx][newy]) {
                    if (searchWord(board, word, index + 1, newx, newy, visited)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;
        return 0 <= x && x < row && 0 <= y && y < col;  
    }
}