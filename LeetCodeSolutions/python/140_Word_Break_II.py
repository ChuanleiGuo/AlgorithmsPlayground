class Solution(object):

    def __break_word(self, res, s, word_dict, string, idx, dp):
        lens = 1
        while idx + lens < len(s) + 1:

            if dp[idx + lens] and s[idx: idx + lens] in word_dict:
                substr = s[idx: idx + lens]

                if idx + lens < len(s):
                    self.__break_word(res, s, word_dict,
                                      string + substr + " ", idx + lens, dp)
                else:
                    res.append(string + substr)
                    return

            lens += 1

    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(len(s)):
            if dp[i]:
                lens = 1
                while i + lens < len(s) + 1:

                    if s[i: i + lens] in wordDict:
                        dp[i + lens] = True

                    lens += 1

        res = []
        if dp[len(s)]:
            self.__break_word(res, s, wordDict, "", 0, dp)

        return res
