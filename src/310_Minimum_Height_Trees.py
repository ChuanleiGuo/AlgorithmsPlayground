from collections import defaultdict


class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        children = defaultdict(set)
        for s, t in edges:
            children[s].add(t)
            children[t].add(s)

        vertices = set(children.keys())

        while len(vertices) > 2:
            leaves = [x for x in children if len(children[x]) == 1]
            for x in leaves:
                for y in children[x]:
                    children[y].remove(x)
                del children[x]
                vertices.remove(x)

        return list(vertices) if n != 1 else [0]

print Solution().findMinHeightTrees(4, [[1, 0], [1, 2], [1, 3]])
