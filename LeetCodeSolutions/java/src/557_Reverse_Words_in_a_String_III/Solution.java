class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] charArray = s.toCharArray();
        int start = 0, end;
        while ((end = find(charArray, ' ', start)) != -1) {
            reverse(charArray, start, end - 1);
            start = end + 1;
        }
        reverse(charArray, start, s.length() - 1);
        return new String(charArray);
    }

    private int find(char[] chars, char target, int start) {
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

}