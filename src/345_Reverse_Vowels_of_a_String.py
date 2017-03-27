class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        letters = list(s)
        start, end = 0, len(letters) - 1
        while start < end:
            while start < end and letters[start] not in vowels:
                start += 1
            while start < end and letters[end] not in vowels:
                end -= 1
            letters[start], letters[end] = letters[end], letters[start]
            start += 1
            end -= 1

        return ''.join(letters)
