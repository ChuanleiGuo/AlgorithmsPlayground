import java.util.ArrayList;
import java.util.List;

public class DiameterOfTree {

    public static class TreeNode {
        List<Edge> edges = new ArrayList<>();
    }

    private static class Edge {
        public TreeNode root;
        public Double length;

        public Edge(TreeNode root, Double length) {
            this.root = root;
            this.length = length;
        }
    }

    private static class HeightAndDiameter {
        public Double height;
        public Double diameter;

        public HeightAndDiameter(Double height, Double diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static HeightAndDiameter computeHeightAndDiameter(TreeNode r) {
        double diameter = Double.MIN_VALUE;
        double[] heights = {0.0, 0.0};
        for (Edge e : r.edges) {
            HeightAndDiameter heightAndDiameter = computeHeightAndDiameter(e.root);
            if (heightAndDiameter.height + e.length > heights[0]) {
                heights[1] = heights[0];
                heights[0] = heightAndDiameter.height + e.length;
            } else if (heightAndDiameter.height + e.length > heights[1]) {
                heights[1] = heightAndDiameter.height + e.length;
            }
            diameter = Math.max(diameter, heightAndDiameter.diameter);
        }
        return new HeightAndDiameter(heights[0], Math.max(diameter, heights[0] + heights[1]));
    }
}
