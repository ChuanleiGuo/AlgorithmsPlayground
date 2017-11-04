public class Division {
    public static long division(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower >= x) {
                yPower >>>= 1;
                power -= 1;
            }
            result += 1L << yPower;
            x -= yPower;
        }
        return result;
    }
}
