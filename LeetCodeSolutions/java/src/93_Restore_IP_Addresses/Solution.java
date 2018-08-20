import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfsHelper(s, 0, 0, "", result);
        return result;
    }

    private void dfsHelper(String s, int idx, int count, String path, List<String> result) {
        if (count >= 4) {
            if (idx == s.length()) {
                result.add(path.substring(0, path.length() - 1));
            }
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            if (i - idx > 3) {
                break;
            }
            if (isValide(s.substring(idx, i))) {
                dfsHelper(s, i, count + 1, path + s.substring(idx, i) + ".", result);
            }
        }
    }
    
    private boolean isValide(String s) {
        if (s.charAt(0) == '0' && !s.equals("0")) {
            return false;
        }
        Integer intValue = Integer.valueOf(s);
        return s.length() < 4 && 0 <= intValue && intValue < 256;
    }
}