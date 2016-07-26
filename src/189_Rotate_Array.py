class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        def reverse(arr, start, end):
            while start < end:
                arr[start], arr[end] = arr[end], arr[start]

                start += 1
                end -= 1

        if nums is None or len(nums) == 0:
            return

        k %= len(nums)
        reverse(nums, 0, len(nums) - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, len(nums) - 1)
