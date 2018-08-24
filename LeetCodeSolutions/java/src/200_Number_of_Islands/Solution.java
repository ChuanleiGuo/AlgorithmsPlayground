class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int newx = x + dirs[i][0];
            int newy = y + dirs[i][1];
            if (inArea(grid, newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                dfs(grid, newx, newy, visited);
            }
        }
    }

    private boolean inArea(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        return 0 <= x && x < row && 0 <= y && y < col;
    }
}