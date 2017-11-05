public class ReverseInteger {
    public static long reverse(ing x) {
        int xRemaining = Math.abs(x);
        long result = 0;
        while (xRemaining != 0) {
            result = result * 10 + xRemaining % 10;
            xRemaining /= 10;
        }
        return x < 0 ? -result : result;
    }
}
