import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsValidSudoku {
    public static boolean isValidSudoku(List<List<Integer>> checkerBoard) {
        for (int i = 0; i < checkerBoard.size(); i++) {
            if (hasDuplicate(checkerBoard, i, i + 1, 0, checkerBoard.size())) {
                return false;
            }
        }
        for (int i = 0; i < checkerBoard.size(); i++) {
            if (hasDuplicate(checkerBoard, 0, checkerBoard.size(), i, i + 1)) {
                return false;
            }
        }
        int regionSize = (int)Math.sqrt(checkerBoard.size());
        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (hasDuplicate(checkerBoard, regionSize * i, regionSize * (i + 1),
                    regionSize * j, regionSize * (j + 1))) {

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasDuplicate(List<List<Integer>> region, int startRow,
        int endRow, int startCol, int endCol) {

        List<Boolean> isPresented = new ArrayList<>(Collections.nCopies(region.size() + 1, false));
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (region.get(i).get(j) != 0 && isPresented.get(region.get(i).get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
