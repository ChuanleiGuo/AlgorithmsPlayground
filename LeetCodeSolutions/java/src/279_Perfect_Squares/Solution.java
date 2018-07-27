import java.util.Deque;
import java.util.LinkedList;

class Solution {

    class StepPair {
        int num;
        int step;

        StepPair(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Deque<StepPair> queue = new LinkedList<>();
        queue.add(new StepPair(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = false;
        
        while (!queue.isEmpty()) {
            StepPair pair = queue.pollFirst();
            int num = pair.num;
            int step = pair.step;

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num - i * i]) {
                    queue.add(new StepPair(num - i * i, step + 1));
                }
            }
        }

        return -1;
    }
}