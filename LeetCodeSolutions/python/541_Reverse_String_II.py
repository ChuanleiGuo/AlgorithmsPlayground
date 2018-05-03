class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        len_s = len(s)
        s_list = list(s)
        i = 0
        while i < len_s:
            j = min(i + k - 1, len_s - 1)
            s_list[i: j + 1] = reversed(s_list[i: j + 1])
            i += 2 * k
        
        return ''.join(s_list)
