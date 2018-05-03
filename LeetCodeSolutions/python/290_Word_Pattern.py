class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        hash_map = {}
        arr = str.split()
        if len(pattern) != len(arr):
            return False

        for i in range(len(arr)):
            c = pattern[i]
            if c in hash_map:
                if hash_map[c] != arr[i]:
                    return False
            else:
                if arr[i] in hash_map.values():
                    return False
                hash_map[c] = arr[i]
        return True
