import java.util.LinkedList;
import java.util.Queue;

public class Solution {
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

    // bfs
    public int numIslands1(char[][] grid) {
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
                    bfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx = p.x + dirs[i][0];
                int newy = p.y + dirs[i][1];
                if (inArea(grid, newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                    visited[newx][newy] = true;
                    queue.offer(new Point(newx, newy));
                }
            }
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
            {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
            {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
            {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
            {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
            {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        System.out.println(new Solution().numIslands1(grid));
    }
}