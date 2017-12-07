public class SnakeString {
    public static String snakeString(String s) {
        StringBuffer result = new StringBuffer();
        for (int i = 1; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        for (int i = 2; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        for (int i = 3; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
