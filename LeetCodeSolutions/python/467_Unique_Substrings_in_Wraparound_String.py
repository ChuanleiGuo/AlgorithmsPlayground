class Solution(object):
    def findSubstringInWraproundString(self, p):
        """
        :type p: str
        :rtype: int
        """
        count = [0] * 26

        max_length_cur = 0
        for i in range(0, len(p)):
            if i > 0 and (ord(p[i]) - ord(p[i - 1]) == 1
                          or ord(p[i - 1]) - ord(p[i]) == 25):

                max_length_cur += 1
            else:
                max_length_cur = 1

            idx = ord(p[i]) - ord('a')
            count[idx] = max(count[idx], max_length_cur)

        return sum(count)
