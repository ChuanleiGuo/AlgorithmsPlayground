class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() <= minLength) {
                minLength = str.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char charAtIdx = strs[0].charAt(i);

            for (int j = 0; j < strs.length; j++) {
                if (charAtIdx != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLength);
    }
}