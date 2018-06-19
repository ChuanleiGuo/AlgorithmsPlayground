import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if ((s == null && t != null) || (s != null && t == null) 
            || (s.length() != t.length())) {

            return false;
        }

        int idx = 0;
        while (idx < s.length()) {
            if ((map.containsKey(s.charAt(idx)) && !map.get(s.charAt(idx)).equals(t.charAt(idx))) ||
                    (!map.containsKey(s.charAt(idx)) && map.containsValue(t.charAt(idx)))) {
                return false;
            } else {
                map.put(s.charAt(idx), t.charAt(idx));
            }
            idx++;
        }
        return true;
    }
}
