class Solution(object):
    def leastBricks(self, wall):
        """
        :type wall: List[List[int]]
        :rtype: int
        """
        if len(wall) == 0:
            return 0
        count = 0
        hash_map = {}
        for row in wall:
            length = 0
            for brick in row[:-1]:
                length += brick
                hash_map[length] = hash_map.get(length, 0) + 1
                count = max(count, hash_map[length])
        
        return len(wall) - count
