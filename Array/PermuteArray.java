import java.util.Collections;
import java.util.List;

public class PermuteArray {
    public static void applyPermutation(List<Integer> perm, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(list, i, perm.get(next));
                int temp = perm.get(next);
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }
}
