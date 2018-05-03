class Solution(object):
    def findAllConcatenatedWordsInADict(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        pre_words = set()
        words = sorted(words, key=len)
        for word in words:
            if self.__can_form(word, pre_words):
                res.append(word)
            pre_words.add(word)
        return res

    def __can_form(self, word, words_set):
        if len(words_set) == 0:
            return False
        dp = [False] * (len(word) + 1)
        dp[0] = True
        for i in range(1, len(word) + 1):
            for j in range(0, i):
                if not dp[j]: continue
                if word[j: i] in words_set:
                    dp[i] = True
                    break
        return dp[len(word)]
