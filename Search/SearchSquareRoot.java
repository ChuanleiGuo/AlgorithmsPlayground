public class SearchSquareRoot {
    public static int squareRoot(int k) {
        long left = 0, right = k;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long midSquared = mid * mid;
            if (midSquared <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)left - 1;
    }
}
