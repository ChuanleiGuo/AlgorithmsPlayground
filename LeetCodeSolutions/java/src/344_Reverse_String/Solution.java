class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
