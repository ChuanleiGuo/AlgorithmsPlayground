class Solution:
    def replaceWords(self, roots, sentence):
        """
        :type roots: List[str]
        :type sentence: str
        :rtype: str
        """
        root_set = set(roots)

        def replace(word):
            for i in range(1, len(word)):
                if word[:i] in root_set:
                    return word[:i]
            return word
        return ' '.join([replace(word) for word in sentence.split(' ')])

print(Solution().replaceWords(["cat", "bat", "rat"], "the cattle was rattled by the battery"))