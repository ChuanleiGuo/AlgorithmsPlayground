class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        def distance(p1, p2):
            dx = p1[0] - p2[0]
            dy = p1[1] - p2[1]
            return dx ** 2 + dy ** 2

        res = 0
        dis_num_pairs = {}
        n = len(points)
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                d = distance(points[i], points[j])
                dis_num_pairs[d] = dis_num_pairs.get(d, 0) + 1

            for val in dis_num_pairs.values():
                res += val * (val - 1)

            dis_num_pairs.clear()

        return res