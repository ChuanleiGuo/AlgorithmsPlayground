import java.util.HashMap;
import java.util.Map;

public class CanFormPalindrome {
    public static boolean canFormPalindrome(String s) {
        Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            if (!charFrequency.containsKey(c)) {
                charFrequency.put(c, 1);
            } else {
                charFrequency.put(c, charFrequency.get(c) + 1);
            }
        }

        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if ((entry.getValue() % 2 != 0) && ++oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}
