import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        final Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(chars[start])) {
                start++;
            }

            while (start < end && !vowels.contains(chars[end])) {
                end--;
            }

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
