class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        l1 = len(s1)
        l2 = len(s2)
        if l1 != l2:
            return False
        if l1 == 1:
            return s1 == s2

        st1 = sorted(s1)
        st2 = sorted(s2)

        for i in range(0, l1):
            if st1[i] != st2[i]:
                return False

        res = False
        i = 1
        while i < l1 and not res:
            s11 = s1[0: i]
            s12 = s1[i: l1]
            s21 = s2[0: i]
            s22 = s2[i: l1]
            res = self.isScramble(s11, s21) and self.isScramble(s12, s22)

            if not res:
                s21 = s2[0: l1 - i]
                s22 = s2[l1 - i: l1]
                res = self.isScramble(s11, s22) and self.isScramble(s12, s21)

            i += 1

        return res
