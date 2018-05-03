class Solution(object):
    def findMinMoves(self, machines):
        """
        :type machines: List[int]
        :rtype: int
        """
        total = sum(machines)
        if (total % len(machines)) != 0:
            return -1
        
        avg, max_pass = total / len(machines), 0
        cnt = 0
        for load in machines:
            cnt += load - avg
            max_pass = max(max_pass, load - avg, abs(cnt))
        return max_pass
