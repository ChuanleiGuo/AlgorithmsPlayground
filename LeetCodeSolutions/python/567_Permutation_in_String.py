from collections import Counter


class Solution(object):
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        def all_zeros(d):
            for num in d.values():
                if num != 0:
                    return False
            return True
        
        if len(s2) < len(s1):
            return False
        
        char_counter = Counter(s1)
        for char in s2[:len(s1)]:
            char_counter[char] -= 1
        if all_zeros(char_counter):
            return True
        
        for i in range(len(s1), len(s2)):
            char_counter[s2[i]] -= 1
            char_counter[s2[i - len(s1)]] += 1
            if all_zeros(char_counter):
                return True
        return False
