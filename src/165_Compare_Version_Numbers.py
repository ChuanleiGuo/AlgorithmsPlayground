class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1 = version1.split('.')
        v2 = version2.split('.')

        i = j = 0
        l1 = len(v1)
        l2 = len(v2)
        while i < l1 or j < l2:
            a = int(v1[i]) if i < l1 else 0
            b = int(v2[i]) if j < l2 else 0

            if a > b:
                return 1
            if a < b:
                return -1

            i += 1
            j += 1

        return 0
