class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        res = [0] * n
        stack = []
        pre = 0
        for log in logs:
            idx, mid, time = log.split(':')
            idx, time = int(idx), int(time)
            if mid == "start":
                if len(stack):
                    res[stack[-1]] += time - pre
                stack.append(idx)
                pre = time
            else:
                res[stack.pop()] += time - pre + 1
                pre = time + 1
        return res
