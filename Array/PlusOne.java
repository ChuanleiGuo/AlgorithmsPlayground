import java.util.List;

public class PlusOne {
    public static List<Integer> plusOne(List<Integer> a) {
        int n = a.size() - 1;
        a.set(n, a.get(n) + 1);
        for (int i = n; i > 0 && a.get(i) == 10; i--) {
            a.set(i, 0);
            a.set(i - 1, a.get(i - 1) + 1);
        }
        if (a.get(0) == 10) {
            a.set(0, 0);
            a.add(0, 1);
        }
        return a;
    }
}
