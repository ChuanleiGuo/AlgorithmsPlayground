import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMaze {

    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            if (x != that.x || y != that.y) {
                return false;
            }
            return true;
        }
    }

    public enum Color {
        WHITE, BLACK
    }

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y, Color.BLACK);
        path.add(s);
        if (!searchMazeHelper(maze, s, e, path)) {
            path.remove(path.size() - 1);
        }
        return path;
    }

    private static boolean searchMazeHelper(List<List<Color>> maze, Coordinate s, Coordinate e, List<Coordinate> path) {
        if (s.equals(e)) {
            return true;
        }

        final int[][] shifts = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] shift : shifts) {
            Coordinate next = new Coordinate(s.x + shift[0], s.y + shift[1]);
            if (isFeasible(maze, next)) {
                maze.get(next.x).set(next.y, Color.BLACK);
                path.add(next);
                if (searchMazeHelper(maze, next, e, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    private static boolean isFeasible(List<List<Color>> maze, Coordinate cur) {
        return cur.x >= 0 && cur.x < maze.size() && cur.y >= 0 && cur.y < maze.get(cur.x).size()
                && maze.get(cur.x).get(cur.y) == Color.WHITE;
    }

    public static boolean pathElementIsFeasible(List<List<Integer>> maze, Coordinate prev, Coordinate cur) {
        if (!(0 <= cur.x && cur.x < maze.size() && 0 <= cur.y && cur.y < maze.get(cur.x).size()
                && maze.get(cur.x).get(cur.y) == 0)) {
            return false;
        }
        return cur.x == prev.x + 1 && cur.y == prev.y || cur.x == prev.x - 1 && cur.y == prev.y
                || cur.x == prev.x && cur.y == prev.y + 1 || cur.x == prev.x && cur.y == prev.y - 1;
    }
}
