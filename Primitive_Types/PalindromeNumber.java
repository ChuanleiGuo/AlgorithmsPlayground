public class PalindromeNumber {
    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }
        final int numDigit = (int)(Math.floor(Math.log10(x))) + 1;
        int mask = (int)Math.pow(10, n - 1);
        for (i = 0; i < (numDigit / 2); i++) {
            if (x / mask != x % 10) {
                return false;
            }
            x %= mask;
            x /= 10;
            mask /= 100;
        }
        return true;
    }
}
