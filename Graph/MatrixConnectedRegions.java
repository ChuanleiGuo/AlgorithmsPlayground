import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixConnectedRegions {

    public static class Coordiante {
        public int x;
        public int y;

        public Coordiante(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void flipColor(int x, int y, List<List<Boolean>> image) {
        int[][] shifts = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Boolean color = image.get(x).get(y);

        Queue<Coordiante> queue = new LinkedList<>();
        image.get(x).set(y, !color);
        queue.add(new Coordiante(x, y));

        while (!queue.isEmpty()) {
            Coordiante coordiante = queue.poll();
            for (int[] shift : shifts) {
                Coordiante next = new Coordiante(coordiante.x + shift[0], coordiante.y + shift[1]);
                if (next.x >= 0 && next.x < image.size() && next.y >= 0 && next.y < image.get(next.x).size()
                        && image.get(next.x).get(next.y) == color) {

                    image.get(next.x).set(next.y, !color);
                    queue.add(next);
                }
            }
        }
        return;
    }
}
