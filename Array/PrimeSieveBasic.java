import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrimeSieveBasic {
    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrimes = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrimes.set(0, false);
        isPrimes.set(1, false);
        for (int i = 2; i <= n; i++) {
            if (isPrimes.get(i)) {
                primes.add(i);
                for (int j = i; j <= n; j += i) {
                    isPrimes.set(j, false);
                }
            }
        }
        return primes;
    }

    public static List<Integer> generatePrimesQuickly(int n) {
        final int size = (int)Math.floor(0.5 * (n - 3)) + 1;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        List<Boolean> isPrimes = new ArrayList<>(Collections.nCopies(size, true));
        for (int i = 0; i < size; i++) {
            if (isPrimes.get(i)) {
                p = i * 2 + 3;
                primes.add(p);
                for (long j = ((i * i) * 2) + 6 * i + 3; j < size; j += p) {
                    isPrimes.set((int)j, false);
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            System.out.println("n = " + n);
            List<Integer> primes = generatePrimes(n);
            for (Integer prime : primes) {
                for (int j = 2; j < prime; ++j) {
                    assert (prime % j != 0);
                }
            }
        } else {
            Random r = new Random();
            for (int times = 0; times < 100; ++times) {
                int n = r.nextInt(999999) + 2;
                System.out.println("n = " + n);
                List<Integer> primes = generatePrimes(n);
                for (Integer prime : primes) {
                    for (int j = 2; j < prime; ++j) {
                        assert (prime % j != 0);
                    }
                }
            }
        }
    }
}
