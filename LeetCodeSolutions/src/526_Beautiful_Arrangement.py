class Solution(object):
    count = 0
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        def helper(idx, used):
            if idx > N:
                self.count += 1
                return
            
            for i in range(1, N + 1):
                if used[i] == 0 and (i % idx == 0 or idx % i == 0):
                    used[i] = True
                    helper(idx + 1, used)
                    used[i] = False
        self.count = 0
        if N == 0:
            return 0
        helper(1, [False] * (N + 1))
        return self.count
