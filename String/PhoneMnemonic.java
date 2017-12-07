import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhoneMnemonic {
    public static List<String> phoneMnemonic(String phoneNumber) {
        char[] partialNumber = new char[phoneNumber.length()];
        List<String> res = new ArrayList<>();
        helper(phoneNumber, 0, partialNumber, res);
        return res;
    }

    private static final String[] MAPPING = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    private static void helper(String phoneNumber, int idx, char[] partial, List<String> res) {
        if (idx == phoneNumber.length()) {
            res.add(new String(partial));
        } else {
            for (int i = 0; i < MAPPING[phoneNumber.charAt(idx) - '0'].length(); i++) {
                partial[idx] = MAPPING[phoneNumber.charAt(idx) - '0'].charAt(i);
                helper(phoneNumber, idx + 1, partial, res);
            }
        }
    }

    static String randString(int len) {
        Random gen = new Random();
        StringBuilder ret = new StringBuilder();
        while (len-- > 0) {
            ret.append(gen.nextInt(10));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String num;
        if (args.length == 1) {
            num = args[0];
        } else {
            num = randString(10);
        }
        List<String> result = phoneMnemonic(num);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("number = " + num);
    }

}
