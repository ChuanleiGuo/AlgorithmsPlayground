public class ShortestPath {

    private int minDistance(int[] dist, boolean[] visited) {
        int numCities = dist.length - 1;
        int min = Integer.MAX_VALUE, minIdx = -1;

        for (int i = 1; i <= numCities; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    public int[] maxRestTime(int numCities, int numRoads, int[][] travelTime, int numDeliveries, int[][] timeLimit) {
        int[][] graph = new int[numCities + 1][numCities + 1];

        for (int i = 0; i < numRoads; i++) {
            int start = travelTime[i][0];
            int end = travelTime[i][1];
            int cost = travelTime[i][2];

            graph[start][end] = graph[end][start] = cost;
        }

        int[] dist = new int[numCities + 1];
        boolean[] visited = new boolean[numCities + 1];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[1] = 0;

        for (int count = 0; count < numCities - 1; count++) {
            int u = minDistance(dist, visited);

            visited[u] = true;

            for (int v = 1; v <= numCities; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]
                ) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        int[] res = new int[numDeliveries];
        for (int i = 0; i < numDeliveries; i++) {
            int target = timeLimit[i][0];
            int limit = timeLimit[i][1];

            res[i] = Math.max(0, limit - dist[target] * 2);
        }

        return res;
    }

    public static void main(String[] args) {
        ShortestPath p = new ShortestPath();
        int numCities = 4, numRoads = 4;
        int[][] travelTime = {
            {1, 2, 5},
            {2, 3, 10},
            {3, 4, 20},
            {1, 4, 1}
        };
        int numDeliveries = 2;
        int[][] timeLimit = {{2, 65}, {3, 15}};

        int[] res = p.maxRestTime(numCities, numRoads, travelTime, numDeliveries, timeLimit);

        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
