class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if not s or len(s) < 10:
            return []

        hashmap = {}
        for i in range(10, len(s) + 1):
            sub = s[i - 10: i]
            hashmap[sub] = hashmap.get(sub, 0) + 1

        res = filter(lambda k: hashmap.get(k, 0) > 1, hashmap)

        return res
