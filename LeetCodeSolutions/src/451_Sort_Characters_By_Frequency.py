from collections import Counter


class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        h1 = Counter(s)
        h2 = {}
        for k, v in h1.items():
            h2.setdefault(v, []).append(k*v)
        return "".join("".join(h2[i]) for i in range(len(s), -1, -1) if i in h2)
