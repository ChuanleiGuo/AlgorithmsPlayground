public class LookAndSay {
    public static String lookAndSay(int n) {
        String start = "1";
        for (int i = 0; i < n; i++) {
            start = nextNumber(start);
        }
        return start;
    }

    private static String nextNumber(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                i++;
                count++;
            }
            result.append(count);
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        assert lookAndSay(1) == "1";
        assert lookAndSay(2) == "11";
        assert lookAndSay(3) == "21";
        assert lookAndSay(4) == "1211";
        assert lookAndSay(5) == "111221";
        assert lookAndSay(6) == "312211";
        assert lookAndSay(7) == "13112221";
        assert lookAndSay(8) == "1113213211";
    }
}
