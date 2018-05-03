class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        cnt = {}
        pos = 0
        for c in s:
            cnt[c] = cnt.get(c, 0) + 1
        for i in range(len(s)):
            if s[i] < s[pos]:
                pos = i
            cnt[s[i]] -= 1
            if cnt[s[i]] == 0:
                break
        return "" if len(s) == 0 else s[pos] \
                                      + self.removeDuplicateLetters(s[pos + 1:].replace(s[pos], ""))
