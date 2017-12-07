public class Palindromicity {
    public static boolean isPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < h) {
                l += 1;
            }
            while (!Character.isLetterOrDigit(s.charAt(h)) && l < h) {
                h -= 1;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(h))) {
                return false;
            }
        }
        return true;
    }
}
