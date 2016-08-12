class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        ranges = []
        for n in nums:
            if not ranges or ranges[-1][-1] + 1 < n:
                ranges.append([])
            ranges[-1][1:] = [n]
        return ['->'.join(map(str, r)) for r in ranges]
