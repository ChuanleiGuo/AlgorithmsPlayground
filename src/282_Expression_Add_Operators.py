class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        res = []
        if not num or len(num) == 0:
            return res
        self.helper(res, '', num, target, 0, 0, 0)
        return res

    def helper(self, res, path, num, target, pos, eval, multed):
        if pos == len(num):
            if eval == target:
                res.append(path)
            return

        for i in range(pos, len(num)):
            if i != pos and num[pos] == '0':
                break

            cur = int(num[pos: i + 1])
            if pos == 0:
                self.helper(res, path + str(cur), num, target, i + 1, cur, cur)
            else:
                self.helper(res, path + '+' + str(cur), num,
                            target, i + 1, eval + cur, cur)
                self.helper(res, path + '-' + str(cur), num,
                            target, i + 1, eval - cur, -cur)
                self.helper(res, path + '*' + str(cur), num,
                            target, i + 1, eval - multed + (multed * cur), multed * cur)
