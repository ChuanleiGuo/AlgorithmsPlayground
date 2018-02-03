import java.util.List;

public class FindDuplicateAndMissing {
    private static class DuplicateAndMissing {
        public Integer duplicate;
        public Integer missing;

        public DuplicateAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }
    }

    public static DuplicateAndMissing findDuplicateAndMissing(List<Integer> list) {
        int missXORDup = 0;
        for (int i = 0; i < list.size(); i++) {
            missXORDup ^= i ^ list.get(i);
        }

        int differBit = missXORDup & (~(missXORDup - 1));
        int missOrDup = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((i & differBit) != 0) {
                missOrDup ^= i;
            }
            if ((list.get(i) & differBit) != 0) {
                missOrDup ^= list.get(i);
            }
        }

        for (int a : list) {
            if (a == missOrDup) {
                return new DuplicateAndMissing(missOrDup , missOrDup ^ missXORDup);
            }
        }
        return new DuplicateAndMissing(missOrDup ^ missXORDup, missOrDup);
    }
}
