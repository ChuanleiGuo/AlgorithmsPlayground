class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        total, s, start = 0, 0, 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]
            if s < 0:
                s = gas[i] - cost[i]
                start = i
            else:
                s += gas[i] - cost[i]
        return -1 if total < 0 else start
