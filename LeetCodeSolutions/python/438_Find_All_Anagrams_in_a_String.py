from collections import Counter


class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        p_counter = Counter(p)
        s_counter = Counter(s[: len(p) - 1])
        for i in range(len(p) - 1, len(s)):
            s_counter[s[i]] += 1
            if s_counter == p_counter:
                res.append(i - len(p) + 1)
            s_counter[s[i - len(p) + 1]] -= 1
            if s_counter[s[i - len(p) + 1]] == 0:
                del s_counter[s[i - len(p) + 1]]
        return res
