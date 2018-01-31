import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class FindMissingIP {

    private static final int NUM_BUCKET = 1 << 16;

    public static int findMissingElement(Iterable<Integer> sequence) {
        int[] counter = new int[NUM_BUCKET];
        Iterator<Integer> s = sequence.iterator();
        while (s.hasNext()) {
            int idx = s.next() >>> 16;
            ++counter[idx];
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < NUM_BUCKET) {
                BitSet bitVec = new BitSet(NUM_BUCKET);
                s = sequence.iterator();
                while (s.hasNext()) {
                    int x = s.next();
                    if (i == (x >>> 16)) {
                        bitVec.set(((NUM_BUCKET) - 1) & x);
                    }
                }

                for (int j = 0; j < (1 << 16); j++) {
                    if (!bitVec.get(j)) {
                        return (i << 16) | j;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 990000;
        Random r = new Random();
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        Set<Integer> hash = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x;
            do {
                x = r.nextInt(1000000);
            } while (!hash.add(x));
            sequence.add(x);
        }

        int missing = findMissingElement(sequence);
        assert (!hash.contains(missing));
        System.out.println(missing);
    }
}
