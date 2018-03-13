import java.util.Collections;
import java.util.List;

public class FindSalaryCap {
    public static double findSalaryCap(double targetPayroll, List<Double> currentSalaries) {
        Collections.sort(currentSalaries);
        double unadjustedSalarySum = 0;
        for (int i = 0; i < currentSalaries.size(); i++) {
            final double adjustedSum = currentSalaries.get(i) * (currentSalaries.size() - i);
            if (unadjustedSalarySum + adjustedSum >= targetPayroll) {
                return (targetPayroll - unadjustedSalarySum) / (currentSalaries.size() - i);
            }
            unadjustedSalarySum += currentSalaries.get(i);
        }
        return -1.0;
    }
}
