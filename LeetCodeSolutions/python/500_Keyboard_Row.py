class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        import re
        return filter(re.compile("(?i)([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*)$").match, words)