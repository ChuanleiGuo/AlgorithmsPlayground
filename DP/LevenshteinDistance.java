import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LevenshteinDistance {

    public static int levenshteinDistance(String left, String right) {
        int[][] distances = new int[left.length()][right.length()];
        for (int[] row : distances) {
            Arrays.fill(row, -1);
        }
        return computeDistance(left, left.length() - 1, right, right.length() - 1, distances);
    }

    private static int computeDistance(String left, int left_idx, String right, int right_idx, int[][] distances) {

        if (left_idx < 0) {
            return right_idx + 1;
        } else if (right_idx < 0) {
            return left_idx + 1;
        }

        if (distances[left_idx][right_idx] == -1) {
            if (left.charAt(left_idx) == right.charAt(right_idx)) {
                distances[left_idx][right_idx] = computeDistance(left, left_idx - 1, right, right_idx - 1, distances);
            } else {
                int substituteLast = computeDistance(left, left_idx - 1, right, right_idx - 1, distances);
                int addLast = computeDistance(left, left_idx, right, right_idx - 1, distances);
                int deleteLast = computeDistance(left, left_idx - 1, right, right_idx, distances);
                distances[left_idx][right_idx] = 1 + Math.min(substituteLast, Math.min(addLast, deleteLast));
            }
        }

        return distances[left_idx][right_idx];
    }

    public static int checkAnswer(String A, String B) {
        // Try to reduce the space usage.
        if (A.length() < B.length()) {
            String temp = A;
            A = B;
            B = temp;
        }

        List<Integer> D = new ArrayList<>(B.length() + 1);
        // Initialization.
        for (int i = 0; i < B.length() + 1; i++) {
            D.add(i);
        }

        for (int i = 1; i <= A.length(); ++i) {
            int preI1J1 = D.get(0); // Stores the value of D.get(i - 1).get(j - 1).
            D.set(0, i);
            for (int j = 1; j <= B.length(); ++j) {
                int preI1J = D.get(j); // Stores the value of D.get(i -1).get(j).
                D.set(j, A.charAt(i - 1) == B.charAt(j - 1) ? preI1J1
                        : 1 + Math.min(preI1J1, Math.min(D.get(j - 1), D.get(j))));
                // Previous D.get(i - 1).get(j) will become the next D.get(i - 1).get(j
                // - 1).
                preI1J1 = preI1J;
            }
        }
        return D.get(D.size() - 1);
    }

    private static String randString(int len) {
        Random r = new Random();
        StringBuilder ret = new StringBuilder(len);
        while (len-- > 0) {
            ret.append((char) (r.nextInt(26) + 'a'));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Random r = new Random();
        String A, B;
        A = "k";
        B = "sitt";
        assert (4 == levenshteinDistance(A, B));
        cache = new HashMap<Key, Integer>();
        assert (4 == levenshteinDistanceRecursive(A, B));
        // Wiki example (http://en.wikipedia.org/wiki/levenshteinDistance)
        A = "Saturday";
        B = "Sunday";
        assert (3 == levenshteinDistance(A, B));
        cache = new HashMap<Key, Integer>();
        assert (3 == levenshteinDistanceRecursive(A, B));
        A = "kitten";
        B = "sitting";
        assert (3 == levenshteinDistance(A, B));
        cache = new HashMap<Key, Integer>();
        assert (3 == levenshteinDistanceRecursive(A, B));

        if (args.length == 2) {
            A = args[0];
            B = args[1];
        } else {
            A = randString(r.nextInt(100) + 1);
            B = randString(r.nextInt(100) + 1);
        }
        System.out.println(A + "\n" + B);
        System.out.println(levenshteinDistance(A, B));
        cache = new HashMap<Key, Integer>();
        System.out.println(levenshteinDistanceRecursive(A, B));
    }

    // must initialize before each run
    static Map<Key, Integer> cache;

    static class Key {
        int aPrefixLength;
        int bPrefixLength;

        Key(int x, int y) {
            aPrefixLength = x;
            bPrefixLength = y;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(aPrefixLength).hashCode() + Integer.valueOf(bPrefixLength).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key that = (Key) obj;
            return aPrefixLength == that.aPrefixLength && bPrefixLength == that.bPrefixLength;
        }

        @Override
        public String toString() {
            return "" + aPrefixLength + "," + bPrefixLength;
        }
    }

    public static int levenshteinDistanceRecursive(String A, String B) {
        if (A.length() == 0) {
            System.out.println("distance for " + A + "-" + B + " is " + B.length());
            return B.length();
        } else if (B.length() == 0) {
            System.out.println("distance for " + A + "-" + B + " is " + A.length());
            return A.length();
        }
        Key key = new Key(A.length(), B.length());
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result;
        if (A.charAt(A.length() - 1) == B.charAt(B.length() - 1)) {
            result = levenshteinDistanceRecursive(A.substring(0, A.length() - 1), B.substring(0, B.length() - 1));
            System.out.println("distance for " + A + "-" + B + " is " + result);
        } else {
            int case1 = levenshteinDistanceRecursive(A.substring(0, A.length() - 1), B.substring(0, B.length()));
            int case2 = levenshteinDistanceRecursive(A.substring(0, A.length()), B.substring(0, B.length() - 1));
            int case3 = levenshteinDistanceRecursive(A.substring(0, A.length() - 1), B.substring(0, B.length() - 1));
            result = 1 + Math.min(Math.min(case1, case2), case3);
        }
        cache.put(key, result);
        System.out.println("distance for " + A + "-" + B + " is " + result);
        assert (levenshteinDistance(A, B) == checkAnswer(A, B));
        return result;
    }
}
