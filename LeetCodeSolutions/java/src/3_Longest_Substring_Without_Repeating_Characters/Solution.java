class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = -1;
        int[] freq = new int[256];
        int maxLen = 0;
        
        while (left < s.length()) {
            if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
                right++;
                freq[s.charAt(right)]++;
            } else {
                freq[s.charAt(left)]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
