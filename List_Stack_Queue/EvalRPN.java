import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN {
    public static int eval(String rpnExpression) {
        Deque<Integer> interResult = new LinkedList<>();
        String delimeter = ",";
        String[] symbols = rpnExpression.split(delimeter);
        for (String token : symbols) {
            if (token.length() == 1 && "+-*/".contains(token)) {
                final int y = interResult.removeFirst();
                final int x = interResult.removeFirst();
                switch (token.charAt(0)) {
                case '+':
                    interResult.addFirst(x + y);
                    break;
                case '-':
                    interResult.addFirst(x - y);
                    break;
                case '*':
                    interResult.addFirst(x * y);
                    break;
                case '/':
                    interResult.addFirst(x / y);
                    break;
                default:
                    throw new IllegalArgumentException("Malformed RPN at :" + token);
                }
            } else {
                interResult.add(Integer.parseInt(token));
            }
        }
        return interResult.removeFirst();
    }

    public static void main(String[] args) {
        assert (0 == eval("2,-10,/"));
        assert (-5 == eval("-10,2,/"));
        assert (5 == eval("-10,-2,/"));
        assert (-5 == eval("5,10,-"));
        assert (6 == eval("-10,-16,-"));
        assert (12 == eval("10,2,+"));
        assert (15 == eval("1,2,+,3,4,*,+"));
        assert (42 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+"));
        assert (-6 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+,-7,/"));
    }
}
