class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        length = len(citations)
        count = [0] * (length + 1)

        for c in citations:
            if c > length:
                count[length] += 1
            else:
                count[c] += 1

        total = 0
        for i in range(length, -1, -1):
            total += count[i]
            if total >= i:
                return i

        return 0
