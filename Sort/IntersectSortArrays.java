import java.util.ArrayList;
import java.util.List;

public class IntersectSortArrays {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> a, List<Integer> b) {
        List<Integer> intersectAB = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) == b.get(j) && (i == 0 || a.get(i) != a.get(i - 1))) {
                intersectAB.add(a.get(i));
                i ++;
                j ++;
            } else if (a.get(i) > b.get(j)) {
                j ++;
            } else {
                i ++;
            }
        }
        return intersectAB;
    }
}
