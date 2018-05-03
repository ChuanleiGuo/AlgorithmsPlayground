class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        if len(stones) == 0 or stones[0] != 0 or stones[1] != 1:
            return False

        from collections import defaultdict
        stone_reach_dict = defaultdict(set)

        stone_reach_dict[0].add(1)

        for stone in stones:
            for step in stone_reach_dict[stone]:
                reach = stone + step
                if reach == stones[-1]:
                    return True
                if step - 1 > 0:
                    stone_reach_dict[reach].add(step - 1)
                stone_reach_dict[reach].add(step)
                stone_reach_dict[reach].add(step + 1)
        return False
