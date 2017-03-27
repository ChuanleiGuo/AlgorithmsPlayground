class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s or len(s) == 0:
            return ''

        result = []
        word = ''
        for letter in s:
            if letter == ' ':
                if word != '':
                    result.insert(0, str(word))
                    word = ''
                continue
            else:
                word += letter
        if word != '':
            result.insert(0, word)
        return ' '.join(result)
