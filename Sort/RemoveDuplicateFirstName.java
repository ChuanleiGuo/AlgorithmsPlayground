import java.util.Collections;
import java.util.List;

public class RemoveDuplicateFirstName {
    public static class Name implements Comparable {
        public String firstName;
        public String secondName;

        @Override
        public int compareTo(Name name) {
            int cmp = firstName.compareTo(name.firstName);
            if (cmp != 0) {
                return cmp;
            } else {
                return secondName.compareTo(name.secondName);
            }
        }
    }

    public static void removeDuplicateFirstName(List<Name> names) {
        Collections.sort(names);
        int result = 0;
        for (int first = 1; first < names.size(); first++) {
            if (names.get(first).firstName != names.get(i).firstName) {
                names.set(++result, names.get(first));
            }
        }
        names.subList(++result, names.size()).clear();
    }
}
