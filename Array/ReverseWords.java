import java.util.Random;

public class ReverseWords {
    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length);

        int start = 0, end;
        while ((end = find(s, ' ', start)) != -1) {
            reverse(s, start, end);
            start = end + 1;
        }
        reverse(s, start, s.length);
    }

    private static void reverse(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        int last = end - 1;
        while (start <= last) {
            char temp = s[start];
            s[start] = s[last];
            s[last] = temp;

            start++;
            last--;
        }
    }

    private static int find(char[] s, char c, int start) {
        for (int i = start; i < s.length; i++) {
            if (s[i] == c) {
                return i;
            }
        }
        return -1;
    }

    static String randString(int len) {
        Random gen = new Random();
        StringBuilder ret = new StringBuilder();
        while (len-- > 0) {
            int ch = gen.nextInt(53);
            if (ch == 52) {
                ret.append(' ');
            } else if (ch < 26) {
                ret.append(ch + 'a');
            } else {
                ret.append(ch - 26 + 'A');
            }
        }
        return ret.toString();
    }

    private static void checkAnswer(String ori, String str) {
        char[] input = str.toCharArray();
        reverseWords(input);
        assert ori.equals(new String(input));
    }

    private static void simpleTest() {
        char[] input = "a cat and dog".toCharArray();
        reverseWords(input);
        assert "dog and cat a".equals(new String(input));
        input = "dog".toCharArray();
        reverseWords(input);
        assert "dog".equals(new String(input));
    }

    public static void main(String[] args) {
        simpleTest();
        Random gen = new Random();
        for (int times = 0; times < 1000; ++times) {
            StringBuilder str = new StringBuilder();
            if (args.length >= 1) {
                str.append(args[0]);
                for (int i = 1; i < args.length; ++i) {
                    str.append(' ').append(args[i]);
                }
            } else {
                str.append(randString(gen.nextInt(10000)));
            }
            System.out.println(str);
            char[] input = str.toString().toCharArray();
            reverseWords(input);
            checkAnswer(str.toString(), new String(input));
        }
    }
}
