public class NumberOfTraversalsStaircase {

    public static int numberOfWaysToTop(int top, int maximumStep) {
        return computeNumberOfWaysToTop(top, maximumStep, new int[top + 1]);
    }

    private static int computeNumberOfWaysToTop(int top, int maximumStep, int[] numberOfWaysToTop) {
        if (top <= 1) {
            return 1;
        }

        if (numberOfWaysToTop[top] == 0) {
            for (int i = 1; i <= maximumStep && top - i >= 0; i++) {
                numberOfWaysToTop[top] += computeNumberOfWaysToTop(top - i, maximumStep, numberOfWaysToTop);
            }
        }

        return numberOfWaysToTop[top];
    }
}
