public class MultiplyShiftAdd {
    public static long multiply(long x, long y) {
        long res = 0;
        while (x != 0) {
            if (x & 1) {
                res = add(res, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return res;
    }

    private static long add(long x, long y) {
        long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
        while (tempA != 0 || tempB != 0) {
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= (ak ^ bk ^ carryin);
            carryin = carryout << 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }
        return sum;
    }
}
