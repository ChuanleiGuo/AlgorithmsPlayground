class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        a_cnt, b_cnt = 0, 0
        s_vec = [0] * 10
        g_vec = [0] * 10

        if len(secret) != len(guess) or len(secret) == 0:
            return '0A0B'

        for i in range(len(secret)):
            c1, c2 = secret[i], guess[i]
            if c1 == c2:
                a_cnt += 1
            else:
                s_vec[int(c1)] += 1
                g_vec[int(c2)] += 1

        for i in range(len(s_vec)):
            b_cnt += min(s_vec[i], g_vec[i])

        return '%dA%dB' % (a_cnt, b_cnt)
