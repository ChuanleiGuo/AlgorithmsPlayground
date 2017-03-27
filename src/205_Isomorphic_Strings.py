class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        char_map, target = {}, set()

        for c1, c2 in zip(s, t):
            if c1 in char_map:
                if char_map[c1] != c2:
                    return False
            else:
                if c2 in target:
                    return False
                char_map[c1] = c2
                target.add(c2)
        return True
