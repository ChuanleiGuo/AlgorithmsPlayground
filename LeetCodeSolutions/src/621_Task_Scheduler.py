from heapq import heapify
from collections import Counter


class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        counts = Counter(tasks)
        pq = []
        for _, v in counts.items():
            pq.append((-v, v))
            heapify(pq)
        
        all_time = 0
        cycle = n + 1
        while len(pq):
            time = 0
            tmp = []
            for i in range(cycle):
                if len(pq):
                    tmp.append(pq[0][1])
                    del pq[0]
                    time += 1
            for cnt in tmp:
                cnt -= 1
                if cnt:
                    pq.append((-cnt, cnt))
                    heapify(pq)

            all_time += cycle if len(pq) else time

        return all_time
