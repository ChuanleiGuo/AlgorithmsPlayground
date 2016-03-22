class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        i, j = 0, 0
        star = -1
        s_star = 0
        s_len = len(s)
        p_len = len(p)
        while i < s_len:
            if (i < s_len and j < p_len) and (s[i] == p[j] or p[j] == '?'):
                i += 1
                j += 1
            elif j < p_len and p[j] == '*':
                star = j
                s_star = i
                j += 1
            elif star != -1:
                j = star + 1
                s_star += 1
                i = s_star
            else:
                return False
        while j < p_len and p[j] == '*':
            j += 1
        return j == p_len
