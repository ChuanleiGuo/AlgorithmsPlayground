class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        from collections import deque
        if not nums or len(nums) == 0:
            return []
        length = len(nums)
        res = [0] * (length - k + 1)
        ri = 0

        q = deque()
        for i in range(0, length):
            while len(q) and q[0] < i - k + 1:
                q.popleft()

            while len(q) and nums[q[-1]] < nums[i]:
                q.pop()

            q.append(i)
            if i >= k - 1:
                res[ri] = nums[q[0]]
                ri += 1
        return res

print Solution().maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3)
