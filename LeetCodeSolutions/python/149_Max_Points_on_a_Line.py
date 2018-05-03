class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b


class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """

        def get_gcd(x, y):
            if y == 0:
                return x
            else:
                return get_gcd(y, x % y)

        if points is None:
            return 0
        if len(points) == 0:
            return 0

        hash_map = {}
        result = 0
        for i in range(len(points)):
            hash_map.clear()
            overlap, max_num = 0, 0
            for j in range(i + 1, len(points)):
                x = points[j].x - points[i].x
                y = points[j].y - points[i].y

                if x == 0 and y == 0:
                    overlap += 1
                    continue

                gcd = get_gcd(x, y)
                if gcd != 0:
                    x /= gcd
                    y /= gcd

                if x in hash_map:
                    if y in hash_map[x]:
                        hash_map[x][y] += 1
                    else:
                        hash_map[x][y] = 1
                else:
                    m = {y: 1}
                    hash_map[x] = m

                max_num = max(max_num, hash_map[x][y])

            result = max(result, max_num + overlap + 1)

        return result
