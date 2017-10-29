public class ReverseBits {

    private static long reverseBits(long x, int n) {
        for (int i = 0, j = n; i < j; ++i, --j) {
          x = SwapBits.swapBits(x, i, j);
        }
        return x;
    }

    private long[] precomputedReverse = new long[1 << 16];

    private void computeReverseTable() {
        for (int i = 0; i < (1 << 16); i++) {
            precomputedReverse[i] = reverseBits(i, 15);
        }
    }

    public static long reverseBits(long x) {
        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return precomputed[(int)(x & BIT_MASK)] << (3 * MASK_SIZE)
            | precomputed[(int)((x >>> MASK_SIZE) & BIT_MASK)] << (2 * MASK_SIZE)
            | precomputed[(int)((x >>> (2 * MASK_SIZE)) & BIT_MASK)] << MASK_SIZE
            | precomputed[(int)((x >>> (3 * MASK_SIZE)) & BIT_MASK)] << MASK_SIZE;
    }
}
