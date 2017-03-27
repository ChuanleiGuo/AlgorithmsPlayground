class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        char_num_map = {}
        for char in magazine:
            char_num_map[char] = char_num_map.get(char, 0) + 1

        for char in ransomNote:
            if char not in char_num_map or char_num_map[char] <= 0:
                return False
            char_num_map[char] -= 1

        return True
