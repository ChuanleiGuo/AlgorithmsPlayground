class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        if candidates is None or len(candidates) == 0:
            return res
        candidates.sort()
        self._dfs(res, [], 0, candidates, target, 0)
        return res

    def _dfs(self, res, path, total, candidates, target, pos):
        if total == target:
            res.append([] + path)
            return
        for i in range(pos, len(candidates)):
            if total + candidates[i] > target:
                return
            if i != pos and candidates[i] == candidates[i - 1]:
                continue
            path.append(candidates[i])
            self._dfs(res, path, total + candidates[i], candidates, target, i + 1)
            path.pop()
cans = [10, 1, 2, 7, 6, 1, 5]
print Solution().combinationSum2(cans, 8)
