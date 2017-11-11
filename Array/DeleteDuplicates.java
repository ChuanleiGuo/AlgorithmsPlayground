import java.util.List;

public class DeleteDuplicates {
    public static int deleteDuplicates(List<Integer> l) {
        if (l.isEmpty()) {
            return 0;
        }
        int writeIndex = 1;
        for (int i = 1; i < l.size(); i++) {
            if (!l.get(writeIndex).equals(l.get(i))) {
                l.set(writeIndex++, l.get(i));
            }
        }
        return writeIndex;
    }
}
