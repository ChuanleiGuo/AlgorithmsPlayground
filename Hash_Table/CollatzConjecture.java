import java.util.HashSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CollatzConjecture {
    public static boolean testCollatzConjecture(int n) {
        Set<Long> verifiedNumbers = new HashSet<>();

        for (int i = 3; i <= n; i += 2) {
            Set<Long> seq = new HashSet<>();
            long testInt = i;
            while (testInt >= i) {
                if (!seq.add(testInt)) {
                    return false;
                }

                if ((testInt % 2) != 0) {
                    if (!verifiedNumbers.add(testInt)) {
                        break;
                    }
                    long nextInt = testInt * 3 + 1;
                    if (nextInt <= testInt) {
                        throw new ArithmeticException("overflow for :" + i);
                    }
                    testInt = nextInt;
                } else {
                    testInt /= 2;
                }
            }
        }
        return true;
    }

    public static boolean check(int n) {
        for (int i = 2; i <= n; ++i) {
            int testI = i;
            while (testI != 1 && testI >= i) {
                if ((testI % 2) != 0) {
                    testI = testI * 3 + 1;
                } else {
                    // clang-format off
                    testI >>>= 1;
                    // clang-format on
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int times = 0; times < 1000; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.parseInt(args[0]);
            } else {
                n = r.nextInt(100000) + 1;
            }
            System.out.println("n = " + n);
            boolean res = testCollatzConjecture(n);
            System.out.println(res);
            assert (res == check(n));
        }
    }
}
