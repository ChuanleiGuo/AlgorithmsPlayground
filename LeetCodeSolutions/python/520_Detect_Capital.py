class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        first_letter = word[0]
        if not word[1:]:
            return True
        if first_letter.islower():
            if not word[1:].islower():
                return False
        elif first_letter.isupper():
            if word[1:].islower() or word[1:].isupper():
                return True
            return False
        return True
