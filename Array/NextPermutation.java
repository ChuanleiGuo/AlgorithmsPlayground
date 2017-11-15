import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NextPermutation {

    public static <T> boolean equal(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> nextPermutation(List<Integer> numbers) {
        int idx = numbers.size() - 2;
        while (idx >= 0 && numbers.get(idx) >= numbers.get(idx + 1)) {
            idx--;
        }
        if (idx == -1) {
            return Collections.emptyList();
        }
        for (int i = numbers.size() - 1; i > idx; i--) {
            if (numbers.get(i) > numbers.get(idx)) {
                Collections.swap(numbers, i, idx);
                break;
            }
        }
        Collections.reverse(numbers.subList(idx + 1, numbers.size()));
        return numbers;
    }

    private static List<Integer> goldenNextPermutation(final List<Integer> c) {
        // 1. finds the largest k, that c[k] < c[k+1]
        List<Integer> result = new ArrayList<>(c);
        int first = getFirst(result);
        if (first == -1) { // no greater permutation
            return Collections.emptyList();
        }

        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = c.size() - 1;
        while (Integer.compare(c.get(first), c.get(toSwap)) >= 0) {
            --toSwap;
        }

        // 3. swap elements with indexes first and last
        Collections.swap(result, first++, toSwap);

        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.size() - 1;
        while (first < toSwap) {
            Collections.swap(result, first++, toSwap--);
        }

        return result;
    }

    private static int getFirst(final List<Integer> c) {
        for (int i = c.size() - 2; i >= 0; --i) {
            if (Integer.compare(c.get(i), c.get(i + 1)) < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int times = 0; times < 1000; ++times) {
            List<Integer> perm = new ArrayList<>();
            if (args.length > 1) {
                for (int i = 1; i < args.length; ++i) {
                    perm.add(Integer.parseInt(args[i]));
                }
            } else {
                Random gen = new Random();
                int n = (args.length == 1 ? Integer.parseInt(args[0]) : (gen.nextInt(10) + 1));
                for (int i = 0; i < n; ++i) {
                    perm.add(gen.nextInt(n));
                }
            }
            // goldenNextPermutation does not change does not change perm
            List<Integer> gold = goldenNextPermutation(perm);

            List<Integer> ans = nextPermutation(perm);

            assert gold.equals(ans);
        }
    }
}
