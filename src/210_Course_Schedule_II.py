class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        from collections import deque
        ind = [0] * numCourses
        outd = [[] for _ in xrange(numCourses)]

        for p in prerequisites:
            ind[p[0]] += 1
            outd[p[1]].append(p[0])

        q = deque()
        for i in range(numCourses):
            if ind[i] == 0:
                q.append(i)

        count = 0
        res = []
        while len(q):
            x = q.popleft()
            res.append(x)
            count += 1
            for node in outd[x]:
                ind[node] -= 1
                if ind[node] == 0:
                    q.append(node)

        return res if count == numCourses else []
