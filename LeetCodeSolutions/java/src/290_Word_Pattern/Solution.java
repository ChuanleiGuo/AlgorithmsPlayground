import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.trim().split("\\s+");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            char a = pattern.charAt(i);
            if (!map.containsKey(a)) {
                if(!map.containsValue(words[i])) {
                    map.put(a, words[i]);
                } else {
                    return false;
                }
            } else if(!map.get(a).equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
