import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, col - 1});
            pacific[i][0] = true;
            atlantic[i][col - 1] = true;
        }

        for (int i = 0; i < col; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{row - 1, i});
            pacific[0][i] = true;
            atlantic[row - 1][i] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int newX = cur[0] + d[0];
                int newY = cur[1] + d[1];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col || 
                        visited[newX][newY] || matrix[newX][newY] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY});
            }
        }
    }
}