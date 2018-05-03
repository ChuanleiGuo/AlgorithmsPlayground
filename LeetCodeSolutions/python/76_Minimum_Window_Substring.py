class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        begin, end = 0, 0
        min_begin, min_end = 0, 0
        min_size = float('inf')
        need_find = {}
        found = {}
        for c in t:
            need_find[c] = need_find.get(c, 0) + 1
        found[s[0]] = found.get(s[0], 0) + 1
        count = len(t)
        if need_find.get(s[0], 0) >= found.get(s[0], 0):
            count -= 1

        while True:
            if count == 0:
                while found.get(s[begin], 0) > need_find.get(s[begin], 0):
                    found[s[begin]] -= 1
                    begin += 1
                size = end - begin + 1
                if size < min_size:
                    min_begin, min_end = begin, end
                    min_size = size

            if end < len(s) - 1:
                end += 1
                found[s[end]] = found.get(s[end], 0) + 1
                if need_find.get(s[end], 0) >= found.get(s[end], 0):
                    count -= 1
            else:
                break
        if min_size < float('inf'):
            return s[min_begin: min_end + 1]
        else:
            return ""

print Solution().minWindow("ADOBECODEBANC", "ABC")
