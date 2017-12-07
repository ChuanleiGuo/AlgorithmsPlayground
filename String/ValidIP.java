import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidIP {
    public static List<String> getValidIpAddress(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < 4 && i < s.length(); i++) {
            final String first = s.substring(0, i);
            if (isValidPart(first)) {
                for (int j = 1; j < 4 && i + j < s.length(); j++) {
                    final String second = s.substring(i, i + j);
                    if (isValidPart(second)) {
                        for (int k = 1; k < 4 && i + j + k < s.length(); k++) {
                            final String third = s.substring(i + j, i + j + k);
                            final String forth = s.substring(i + j + k);
                            if (isValidPart(third) && isValidPart(forth)) {
                                result.add(first + "." + second + "." + third + "." + forth);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValidPart(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);
        return 0 <= val && val <= 255;
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            List<String> result = getValidIpAddress(args[0]);
            System.out.println(result);
        }
        List<String> res1 = getValidIpAddress("255255255255");
        assert (res1.size() == 1);
        assert (res1.get(0).equals("255.255.255.255"));
        List<String> res2 = getValidIpAddress("19216811");
        assert (res2.size() == 9);
        List<String> res3 = getValidIpAddress("1111");
        assert (res3.size() == 1);
        assert (res3.get(0).equals("1.1.1.1"));
        List<String> res4 = getValidIpAddress("11000");
        Collections.sort(res4);
        assert (res4.size() == 2);
        assert (res4.get(0).equals("1.10.0.0"));
        assert (res4.get(1).equals("11.0.0.0"));
    }
}
