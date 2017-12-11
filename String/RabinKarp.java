import java.util.Random;

public class RabinKarp {
    public static int rabinKarp(String s, String t) {
        final int BASE = 26;
        int sHash = 0, tHash = 0;
        int powerS = 1;
        for (int i = 0; i < s.length(); i++) {
            powerS = i > 0 ? powerS * BASE : 1;
            sHash = sHash * BASE + s.charAt(i);
            tHash = tHash * BASE + t.charAt(i);
        }

        for (int i = s.length(); i < t.length(); i++) {
            if (sHash == tHash && t.substring(i - s.length(), i).equals(s)) {
                return i - s.length();
            }
            tHash -= t.charAt(i - s.length()) * powerS;
            tHash = tHash * BASE + t.charAt(i);
        }

        if (sHash == tHash && t.substring(t.length() - s.length()).equals(s)) {
            return t.length() - s.length();
        }
        return -1;
    }

    private static int checkAnswer(String t, String s) {
        for (int i = 0; i + s.length() - 1 < t.length(); ++i) {
            boolean find = true;
            for (int j = 0; j < s.length(); ++j) {
                if (t.charAt(i + j) != s.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }
        return -1; // No matching.
    }

    private static String randString(int len) {
        Random r = new Random();
        StringBuilder ret = new StringBuilder(len);
        while (len-- > 0) {
            ret.append((char) (r.nextInt(26) + 'a'));
        }
        return ret.toString();
    }

    private static void smallTest() {
        assert (rabinKarp("GACGCCA", "CGC") == 2);
        assert (rabinKarp("GATACCCATCGAGTCGGATCGAGT", "GAG") == 10);
        assert (rabinKarp("FOOBARWIDGET", "WIDGETS") == -1);
        assert (rabinKarp("A", "A") == 0);
        assert (rabinKarp("A", "B") == -1);
        assert (rabinKarp("A", "") == 0);
        assert (rabinKarp("ADSADA", "") == 0);
        assert (rabinKarp("", "A") == -1);
        assert (rabinKarp("", "AAA") == -1);
        assert (rabinKarp("A", "AAA") == -1);
        assert (rabinKarp("AA", "AAA") == -1);
        assert (rabinKarp("AAA", "AAA") == 0);
        assert (rabinKarp("BAAAA", "AAA") == 1);
        assert (rabinKarp("BAAABAAAA", "AAA") == 1);
        assert (rabinKarp("BAABBAABAAABS", "AAA") == 8);
        assert (rabinKarp("BAABBAABAAABS", "AAAA") == -1);
        assert (rabinKarp("FOOBAR", "BAR") > 0);
    }

    public static void main(String args[]) {
        smallTest();
        if (args.length == 2) {
            String t = args[0];
            String s = args[1];
            System.out.println("t = " + t);
            System.out.println("s = " + s);
            assert (checkAnswer(t, s) == rabinKarp(t, s));
        } else {
            Random r = new Random();
            for (int times = 0; times < 10000; ++times) {
                String t = randString(r.nextInt(1000) + 1);
                String s = randString(r.nextInt(20) + 1);
                System.out.println("t = " + t);
                System.out.println("s = " + s);
                assert (checkAnswer(t, s) == rabinKarp(t, s));
            }
        }
    }
}
