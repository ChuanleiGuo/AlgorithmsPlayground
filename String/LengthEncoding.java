public class LengthEncoding {
    public static String decoding(String s) {
        StringBuffer result = new StringBuffer();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count = count * 10 + s.charAt(i) - '0';
            } else {
                while (count > 0) {
                    result.append(s.charAt(i));
                    count--;
                }
            }
        }
        return result.toString();
    }

    public static String encoding(String s) {
        StringBuffer result = new StringBuffer();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                result.append(count);
                result.append(s.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(encoding(args[0]) + ' ' + decoding(args[1]));
        }

        assert ("4a1b3c2a".equals(encoding("aaaabcccaa")));
        assert ("eeeffffee".equals(decoding("3e4f2e")));
        assert ("aaaaaaaaaaffffee".equals(decoding("10a4f2e")));
    }
}
