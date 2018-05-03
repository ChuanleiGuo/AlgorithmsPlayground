class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        nums = list(set(nums))
        if len(nums) < 3:
            return max(nums)

        from heapq import heappush, heappop
        heap = []
        k = 3
        for num in nums:
            if len(heap) < k:
                heappush(heap, num)
            elif num > heap[0]:
                heappop(heap)
                heappush(heap, num)
        return heap[0]
