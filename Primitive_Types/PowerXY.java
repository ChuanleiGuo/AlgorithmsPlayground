public class PowerXY {
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        if (y < 0) {
            x = 1.0 / x;
            power = -power;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }
}
