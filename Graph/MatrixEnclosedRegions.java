import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixEnclosedRegions {

  public static void fillSurroundedRegions(List<List<Character>> board) {

    if (board.isEmpty()) {
      return;
    }

    List<List<Boolean>> visited = new ArrayList<>(board.size());
    for (int i = 0; i < board.size(); i++) {
      visited.add(new ArrayList(Collections.nCopies(board.get(i).size(), false)));
    }

    for (int i = 0; i < board.size(); i++) {
      if (board.get(i).get(0) == 'W' && !visited.get(i).get(0)) {
        markBoundaryRegion(i, 0, board, visited);
      }
      if (board.get(i).get(board.get(i).size() - 1) == 'W'
            && !visited.get(i).get(board.get(i).size() - 1)) {
        markBoundaryRegion(i, board.get(i).size() - 1, board, visited);
      }
    }

    for (int j = 0; j < board.get(0).size(); j++) {
      if (board.get(0).get(j) == 'W' && !visited.get(0).get(j)) {
        markBoundaryRegion(0, j, board, visited);
      }
      if (board.get(board.size() - 1).get(j) == 'W'
            && !visited.get(board.size() - 1).get(j)) {
        markBoundaryRegion(board.size() - 1, j, board, visited);
      }
    }

    for (int i = 1; i < board.size() - 1; i++) {
      for (int j = 1; j < board.get(i).size() - 1; j++) {
        if (board.get(i).get(j) == 'W' && !visited.get(i).get(j)) {
          board.get(i).set(j, 'B');
        }
      }
    }

  }

  private static class Coordinate {
    public Integer x;
    public Integer y;

    public Coordinate(Integer x, Integer y) {
      this.x = x;
      this.y = y;
    }
  }

  private static void markBoundaryRegion(int x, int y, List<List<Character>> board, List<List<Boolean>> visited) {
    Queue<Coordinate> queue = new LinkedList<>();
    queue.add(new Coordinate(x, y));
    visited.get(x).set(y, true);
    while (!queue.isEmpty()) {
      Coordinate curr = queue.poll();
      final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      for (int[] dir : DIRS) {
        Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
        if (next.x >= 0 && next.x < board.size() && next.y >= 0 && next.y < board.get(next.x).size()
              && board.get(next.x).get(next.y) == 'W'
              && !visited.get(next.x).get(next.y)) {

            visited.get(next.x).set(next.y, true);
            queue.add(next);
        }
      }
    }
  }
}
