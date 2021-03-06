import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public static Boolean isWellFormed(String s) {
        Deque<Character> leftChars = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                leftChars.addFirst(s.charAt(i));
            } else {
                if (leftChars.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && leftChars.peekFirst() != '('
                    || s.charAt(i) == ']' && leftChars.peekFirst() != '['
                    || s.charAt(i) == '}' && leftChars.peekFirst() != '{') {

                    return false;
                }
                leftChars.removeFirst();
            }
        }
        return leftChars.isEmpty();
    }

    private static void smallTest() {
        assert (isWellFormed("()"));
        assert (isWellFormed("()[]{}"));
        assert (isWellFormed("[()[]]{}"));
        assert (isWellFormed("(()[]{()[]{}{}})"));
        assert (!isWellFormed("([)]"));
        assert (!isWellFormed("["));
        assert (!isWellFormed("(()[]{()[]{})({}})"));
    }

    public static void main(String[] args) {
        smallTest();
        if (args.length == 1) {
            System.out.println(isWellFormed(args[0]));
        }
    }
}
