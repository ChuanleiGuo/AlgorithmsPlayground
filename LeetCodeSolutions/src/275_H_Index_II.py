class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        length = len(citations)
        left, right = 0, length - 1

        while left <= right:
            mid = left + (right - left) / 2
            if citations[mid] == length - mid:
                return citations[mid]
            elif citations[mid] > length - mid:
                right = mid - 1
            else:
                left = mid + 1
        return length - (right + 1)
