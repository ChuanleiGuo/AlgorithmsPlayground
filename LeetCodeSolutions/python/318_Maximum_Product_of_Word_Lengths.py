class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        masks = [0] * len(words)
        result = 0
        for i in range(len(words)):
            for c in words[i]:
                masks[i] |= 1 << (ord(c) - ord('a'))
            for j in range(i):
                if not (masks[i] & masks[j]):
                    result = max(result, len(words[i]) * len(words[j]))
        return result
