import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
    public static enum Color { RED, WHITE, BLUE }

    public static void dutchFlagPartition(int pivotIndex, List<Color> array) {
        Color pivot = array.get(pivotIndex);

        int smaller = 0, equal = 0, larger = array.size();
        while (equal < larger) {
            if (array.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(array, equal++, smaller++);
            } else if (array.get(equal).ordinal() == pivot.ordinal()) {
                equal++;
            } else {
                Collections.swap(array, equal, larger--);
            }
        }
    }
}
