class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        minLen = min(map(len, strs)) if len(strs) != 0 else 0
        length = 0
        for i in range(minLen):
            char = strs[0][i]
            for j in range(0, len(strs)):
                if char != strs[j][i]:
                    return strs[0][: i]
            length += 1
        return strs[0][0: length] if len(strs) != 0 else ''


