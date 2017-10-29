public class SwapBits {
    public static long swapBits(long x, int i, int j) {
        if (((x >>> 1) & 1) != ((x >>> 1) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
}
