import java.util.List;

public class MergeSortedArray {
    public static void mergeSortedArrays(List<Integer> A, int m, List<Integer> B, int n) {
        int a = m - 1, b = n - 1, writeIdx = m + n - 1;
        while (a >= 0 && b >= 0) {
            A.set(writeIdx-- , A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));
        }
        while (b >= 0) {
            A.set(writeIdx--, B.get(b--));
        }
    }
}
