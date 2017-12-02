import java.util.Random;

public class SpreedSheetColumnEncoding {
    public static int decodeColId(String col) {
        int res = 0;
        for (int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }

    private static String randString(int len) {
        Random r = new Random();
        StringBuilder result = new StringBuilder();
        while (len-- != 0) {
            result.append((char) (r.nextInt('Z' - 'A' + 1) + 'A'));
        }
        return result.toString();
    }

    private static void simpleTest() {
        assert (1 == decodeColId("A"));
        assert (2 == decodeColId("B"));
        assert (26 == decodeColId("Z"));
        assert (27 == decodeColId("AA"));
    }

    public static void main(String[] args) {
        simpleTest();
        Random r = new Random();
        if (args.length == 1) {
            System.out.println(args[0] + " " + decodeColId(args[0]));
        } else {
            String s = randString(r.nextInt(5) + 1);
            System.out.println(s + " " + decodeColId(s));
        }
    }
}
