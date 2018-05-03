class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def dfs(candidates, target, res, pre):
            if candidates[0] > target:
                return
            for i in range(len(candidates))[::-1]:
                if target == candidates[i]:
                    res.insert(0, [candidates[i]] + pre)
                else:
                    dfs(candidates[0: i + 1], target - candidates[i], res, [candidates[i]] + pre)
        res = []
        candidates.sort()
        dfs(candidates, target, res, [])
        return res

candidates = [2, 3, 6, 7]
print Solution().combinationSum(candidates, 7)
