import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> interSums = new HashSet<>();
        int sumOfSquare = n;
        while (!interSums.contains(sumOfSquare)) {
            interSums.add(sumOfSquare);
            sumOfSquare = sumOfSquareOfDigits(sumOfSquare);

            if (sumOfSquare == 1) {
                return true;
            }
        }
        return false;
    }

    private int sumOfSquareOfDigits(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}
