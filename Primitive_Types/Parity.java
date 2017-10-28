public class Parity {

    private static short parityBitByBit(long x) {
        short result = 0;
        for (int i = 0;  i < 64; i++) {
            result ^= 1 & (x >> i);
        }
        return result;
    }

    private static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    private static short parityBitByBitSmart(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x = x & (x - 1);
        }
        return result;
    }

    // use lookup table
    private static short[] precomputedParity;

    static {
        precomputedParity = new short[1 << 16];
        for (int i = 0; i < (1 << 16); i++) {
            precomputedParity[i] = parityBitByBitSmart(i);
        }
    }

    private static short parityTable(long x) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

        short result = precomputedParity[(int)(x & BIT_MASK)];
        x >>>= WORD_SIZE;
        result ^= precomputedParity[(int)(x & BIT_MASK)];
        x >>>= WORD_SIZE;
        result ^= precomputedParity[(int)(x & BIT_MASK)];
        x >>>= WORD_SIZE;
        result ^= precomputedParity[(int)(x & BIT_MASK)];
        return result;
    }

    // associativity
    private static short parityAssoc(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short)(x & 1);
    }
}
