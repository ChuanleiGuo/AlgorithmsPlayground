import java.util.ArrayList;
import java.util.List;

public class DeadlockDetection {

    public static class GraphVertex {
        public enum Color {
            WHITE, GRAY, BLACK
        }

        public Color color;
        public List<GraphVertex> edges;

        public GraphVertex() {
            color = Color.WHITE;
            edges = new ArrayList<>();
        }
    }

    public static boolean isDeadlocked(List<GraphVertex> graph) {
        for (GraphVertex vertex : graph) {
            if (vertex.color == GraphVertex.Color.WHITE && hasCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(GraphVertex cur) {
        if (cur.color == GraphVertex.Color.GRAY) {
            return true;
        }

        cur.color = GraphVertex.Color.GRAY;
        for (GraphVertex next : cur.edges) {
            if (next.color != GraphVertex.Color.BLACK) {
                if (hasCycle(next)) {
                    return true;
                }
            }
        }
        cur.color = GraphVertex.Color.BLACK;
        return false;
    }

}
