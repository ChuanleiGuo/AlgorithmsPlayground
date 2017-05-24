class Solution(object):
    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        def is_subsequence(x):
            it = iter(s)
            return all(c in it for c in x)
        return max(sorted(filter(is_subsequence, d)) + [''], key=len)
