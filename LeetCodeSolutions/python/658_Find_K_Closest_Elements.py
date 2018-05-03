class Solution:
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        low, high = 0, len(arr) - k
        while low < high:
            mid = (low + high) / 2
            if x - arr[int(mid)] > arr[int(mid + k)] - x:
                low = mid + 1
            else:
                high = mid
        return arr[int(low): int(low + k)]
