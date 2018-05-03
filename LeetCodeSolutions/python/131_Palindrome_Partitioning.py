class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """

        def dfs(res, l, s, is_palin, idx):
            length = len(s)
            if idx == length:
                res.append(list(l))
            for i in range(idx, length):
                if is_palin[idx][i]:
                    l.append(s[idx: i + 1])
                    dfs(res, l, s, is_palin, i + 1)
                    l.pop(-1)

        if s is None or len(s) == 0:
            return []
        res = []
        l = []
        length = len(s)
        is_palin = [[False] * length for _ in range(length)]
        i, count = 0, length
        while i < length:
            for j in range(count):
                is_palin[j][j + i] = (s[j] == s[j + i]) and \
                    (True if j + 1 >= j + i - 1 else is_palin[j + 1][i + j - 1])
            i += 1
            count -= 1
        dfs(res, l, s, is_palin, 0)
        return res
