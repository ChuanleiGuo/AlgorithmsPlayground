class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        if not s:
            return True
        if not wordDict:
            return False

        dp = [True] + [False for _ in range(len(s))]

        max_len = len(max(wordDict, key=len))

        for i in range(1, len(s) + 1):
            for j in range(i - 1, max(-1, i - max_len - 1), -1):
                if s[j: i] in wordDict and dp[j]:
                    dp[i] = True
                    break

        return dp[-1]
