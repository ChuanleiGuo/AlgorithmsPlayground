public class ClosestIntSameBits {
    static final int NUM_UNSIGN_BITS = 63;

    public static long closestIntSameBits(long x) {
        for (int i = 0; i < NUM_UNSIGN_BITS - 1; i++) {
            if ((((x >>> i) & 1) != ((x >>> (i + 1)) & 1))) {
                x ^= (1L << i) | (1L << (i + 1));
                return x;
            }
        }
        throw new IllegalArgumentException("All bits are 0 or 1");
    }
}
