import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IsLetterConstructible {
    public static boolean isLetterConstructible(String letter, String magazine) {
        Map<Character, Integer> freqForLetter = new HashMap<Character, Integer>();
        for (char c : letter.toCharArray()) {
            if (!freqForLetter.containsKey(c)) {
                freqForLetter.put(c, 1);
            } else {
                freqForLetter.put(c, freqForLetter.get(c) + 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            if (freqForLetter.containsKey(c)) {
                freqForLetter.put(c, freqForLetter.get(c) - 1);
                if (freqForLetter.get(c) == 0) {
                    freqForLetter.remove(c);
                    if (freqForLetter.isEmpty()) {
                        break;
                    }
                }
            }
        }
        return freqForLetter.isEmpty();
    }

    private static String randString(int len) {
        StringBuilder ret = new StringBuilder();
        Random rnd = new Random();

        while (len-- > 0) {
            ret.append((char) (rnd.nextInt(26) + 97));
        }
        return ret.toString();
    }

    private static void check(String letter, String magazine, boolean expected) {
        if (expected != isLetterConstructible(letter, magazine)) {
            System.err.println(
                    "Your program incorrectly reports that " + (letter.length() > 0 ? letter : "the empty string")
                            + " is" + (expected ? " not" : "") + " constructible from " + magazine);
            System.exit(-1);
        }
    }

    private static void simpleTest() {
        check("123", "456", false);
        check("123", "12222222", false);
        check("123", "1123", true);
        check("123", "123", true);
        check("12323", "123", false);
        check("GATTACA", "A AD FS GA T ACA TTT", true);
        check("a", "", false);
        check("aa", "aa", true);
        check("aa", "aaa", true);
        check("", "123", true);
        check("", "", true);
    }

    public static void main(String[] args) {
        simpleTest();
        String L = null;
        String M = null;
        if (args.length == 2) {
            L = args[0];
            M = args[1];
        } else {
            Random rnd = new Random();
            L = randString(rnd.nextInt(1000) + 1);
            M = randString(rnd.nextInt(100000) + 1);
        }
        System.out.println(L);
        System.out.println(M);
        System.out.println(isLetterConstructible(L, M) ? "true" : "false");
    }
}
