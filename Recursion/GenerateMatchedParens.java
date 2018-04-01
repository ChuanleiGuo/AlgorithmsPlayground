import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateMatchedParens {
    public static List<String> generateBalancedParentheses(int numPairs) {
        List<String> result = new ArrayList<>();
        helper(numPairs, numPairs, "", result);
        return result;
    }

    private static void helper(int leftParensNeed, int rightParensNeed, String validPrefix, List<String> result) {
        if (leftParensNeed == 0 && rightParensNeed == 0) {
            result.add(validPrefix);
            return;
        }

        if (leftParensNeed > 0) {
            helper(leftParensNeed - 1, rightParensNeed, validPrefix + '(', result);
        }

        if (rightParensNeed > 0) {
            helper(leftParensNeed, rightParensNeed - 1, validPrefix + ')', result);
        }
    }

    private static void smallTest() {
        List<String> result = generateBalancedParentheses(1);
        assert (result.size() == 1 && result.get(0).equals("()"));
        result = generateBalancedParentheses(2);
        assert (result.size() == 2 && ((result.get(0).equals("(())") && result.get(1).equals("()()"))
                || (result.get(0).equals("()()") && result.get(1).equals("(())"))));
    }

    public static void main(String[] args) {
        smallTest();
        Random r = new Random();
        int n;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            n = r.nextInt(11);
        }
        System.out.println("n = " + n);
        List<String> result = generateBalancedParentheses(n);
        System.out.println(result);
    }

}
