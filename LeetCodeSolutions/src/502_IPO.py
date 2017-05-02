class Solution(object):
    def findMaximizedCapital(self, k, W, Profits, Capital):
        """
        :type k: int
        :type W: int
        :type Profits: List[int]
        :type Capital: List[int]
        :rtype: int
        """
        from Queue import PriorityQueue

        q = PriorityQueue()
        projects = sorted(zip(Profits, Capital), key=lambda x : x[1])
        j = 0
        for i in range(k):
            while j < len(projects):
                if projects[j][1] > W:
                    break
                else:
                    q.put((-projects[j][0], projects[j][0]))
                j += 1
            if q.empty():
                break
            else:
                W += q.get()[1]
        return W